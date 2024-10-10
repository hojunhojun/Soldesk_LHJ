create table gbraucp_member(
	gm_id varchar2(10 char) primary key,
	gm_pw varchar2(10 char) not null,
	gm_name varchar2(10 char) not null,
	gm_birthday date not null,
	gm_photo varchar2(100 char) not null
);
-- 1) 모든 멤버정보 가져와서

-- 2) id/pw맞는 멤버정보 가져와서 -> M에서 OK
-- SQL injection에 취약
-- primary key 이므로 있으면 1 없으면 0 -> 직관적으로 완벽함
select * from GBRAUCP_MEMBER
where gm_id = 'test1' and gm_pw = 'a1'; -- or gm_id like '%%';
select * from GBRAUCP_NOTICE
-- 3) id맞는 멤버정보 가져와서 -> M에서 조건문으로 pw 비교
-- SQL injection당해도 M에서 조건문으로 검사를 하니..
select gm_id from gbraucp_member where gm_id = 'test1';
-- pw도 마찬가지임

to_date('2002-04-25', 'YYYY-MM-DD')
to_date('20020425', 'YYYYMMDD')
to_date('2002/04/25', 'YYYY/MM/DD')

select * from GBRAUCP_MEMBER where gm_id = '';

delete from GBRAUCP_MEMBER where gm_id = 'test5';

delete from GBRAUCP_NOTICE where gn_no = 9;

update GBRAUCP_MEMBER set gm_pw=?, gm_name=?, gm_photo=? where gm_id=?

create table gbraucp_notice(
	gn_no number(3) primary key,
	gn_title varchar2(50 char) not null,
	gn_txt varchar2(500 char) not null,
	gn_date date not null,
	gn_writer varchar2(10 char) not null, -- 글쓴이 id
	constraint gbraucp_notice_writer		-- 탈퇴하면 -> 글 삭제
		foreign key(gn_writer) references gbraucp_member(gm_id)
		on delete cascade
);
create sequence gbraucp_notice_seq;
select * from GBRAUCP_notice

select *
from (
	select rownum as rn, gn_no, gn_title, gn_txt, gn_date 
	from (
		select gn_no, gn_title, gn_txt, gn_date 
		from gbraucp_notice 
		where gn_title like '%테%' or gn_txt like '%테%'
		order by gn_date desc
	)
)
where rn >= 1 and rn <=3

select count(*) from GBRAUCP_notice where gn_title like '%ㅋ%' or gn_txt like '%ㅋ%';

select * from gbraucp_notice, gbraucp_member where gn_writer = gm_id and gn_no = 13;
select * from gbraucp_notice_reply
-- 글 : 댓글 = 1 : n
-- 글이 지워지면 -> 그 글에 붙어있는 댓글 지워져야함
-- 탈퇴하면 -> 그 사람이 쓴 댓글 삭제? ㅇㅇ 삭제가맞음 
create table gbraucp_notice_reply (
	gnr_no number(4) primary key,
	gnr_txt varchar2(100 char) not null,
	gnr_date date not null,
	gnr_writer varchar2(10 char) not null, -- 댓글 쓴사람 아이디
	gnr_gn_no number(3) not null, -- 소속 글번호
	constraint gnr_gn
		foreign key(gnr_gn_no) references gbraucp_notice(gn_no)
		on delete cascade,
	constraint gnr_w
		foreign key(gnr_writer) references GBRAUCP_MEMBER(gm_id)
		on delete cascade
);
create sequence gbraucp_notice_reply_seq;

select gnr_txt, gnr_writer from gbraucp_notice_reply where gnr_no = ?;