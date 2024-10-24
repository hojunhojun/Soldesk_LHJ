create table gbraucp2_member(
	gm_id varchar2(10 char) primary key,
	gm_pw varchar2(10 char) not null,
	gm_photo varchar2(100 char) not null,
	gm_birthday date not null
);

select * from GBRAUCP2_MEMBER;

create table gbraucp2_sns (
	gs_no number(3) primary key,
	gs_txt varchar2(500 char) not null,
	gs_date date not null,
	gs_writer varchar2(10 char) not null,
	constraint sns_writer
		foreign key(gs_writer) references gbraucp2_member(gm_id)
		on delete cascade
);

create sequence gbraucp2_sns_seq;

select * from gbraucp2_sns;

select gs_no, gs_txt, gs_date, gs_writer, gm_photo from GBRAUCP2_SNS, GBRAUCP2_MEMBER where gs_writer = gm_id order by gs_Date desc;

select * from (select rownum as rn, gs_no, gs_txt, gs_date, gs_writer, gm_photo from (select gs_no, gs_txt, gs_date, gs_writer, gm_photo from gbraucp2_sns, gbraucp2_member where gs_writer = gm_id order by gs_date desc)) where rn >= 3 and rn <= 5a

-- 2
select gs_no, gs_txt, gs_date, gs_writer from (select rownum as rn, gs_no, gs_txt, gs_date, gs_writer from (select * from GBRAUCP2_SNS where gs_writer like '%%' or gs_txt like '%%' order by gs_date desc)) where rn >= 3 and rn <= 5;

-- 1
select gm_id, gm_photo from GBRAUCP2_MEMBER where gm_id in (select gs_writer from (select rownum as rn, gs_no, gs_txt, gs_date, gs_writer from (select * from GBRAUCP2_SNS where gs_writer like '%%' or gs_txt like '%%' order by gs_date desc)) where rn >= 3 and rn <= 5);

-- 3 ( + 2 )
select gs_no, gs_txt, gs_date, gs_writer, gm_photo from (gm_id, gm_photo from GBRAUCP2_MEMBER where gm_id in (select gs_writer from (select rownum as rn, gs_no, gs_txt, gs_date, gs_writer from (select * from GBRAUCP2_SNS where gs_writer like #{search} or gs_txt like #{searcj} order by gs_date desc)) where rn >= 3 and rn <= 5)), (elect gs_no, gs_txt, gs_date, gs_writer from (select rownum as rn, gs_no, gs_txt, gs_date, gs_writer from (select * from GBRAUCP2_SNS where gs_writer like '%%' or gs_txt like '%%' order by gs_date desc)) where rn >= 3 and rn <= 5;) where gm_id = gs.writer order by gs_date desc;

select gs_no, gs_txt, gs_date, gs_writer, gm_photo 
		from (
			select gm_id, gm_photo 
			from GBRAUCP2_MEMBER 
			where gm_id in (
			select gs_writer from (
				select rownum as rn, gs_no, gs_txt, gs_date, gs_writer from 
				(select * from GBRAUCP2_SNS where gs_writer like '%'||#{search}||'%' or gs_txt like '%'||#{search}||'%' 
				order by gs_date desc)) where rn &gt;= #{start} and rn &lt;= #{end})), 
				(select gs_no, gs_txt, gs_date, gs_writer 
				from (select rownum as rn, gs_no, gs_txt, gs_date, gs_writer from 
				(select * from GBRAUCP2_SNS where gs_writer like '%'||#{search}||'%' or gs_txt like '%'||#{search}||'%' order by gs_date desc)) where rn &gt;= #{start} and rn &lt;= #{end}) where gm_id = gs.writer order by gs_date desc;
				

create table GBRAUCP2_sns_reply (
	gsr_no number(4) primary key,
	gsr_gs_no number(3) not null,
	gsr_writer varchar2(10 char) not null,
	gsr_txt varchar2(100 char) not null,
	gsr_date date not null,
	constraint sns_post_reply
		foreign key(gsr_gs_no) references gbraucp2_sns(gs_no)
		on delete cascade,
	constraint sns_reply_writer
		foreign key(gsr_writer) references GBRAUCP2_MEMBER(gm_id)
		on delete cascade
);

create sequence GBRAUCP2_sns_reply_seq;

select * from GBRAUCP2_SNS_reply;

create table gbraucp2_gallery(
   p_no number(4) primary key,
   p_gm_id varchar2(10 char) not null,
   p_name varchar2(20 char) not null,
   p_photo varchar2(100 char) not null,
   constraint gallery_upload
      foreign key(p_gm_id) references gbraucp2_member(gm_id)
      on delete cascade
);

select * from gbraucp2_gallery;

create sequence GBRAUCP2_GALLERY_seq;

drop sequence GBRAUCP2_GALLERY_seq;

drop table gbraucp2_gallery cascade constraint purge;

create table gbraucp2_dataroom(
	gd_no number(4) primary key,
	gd_gm_id varchar2(10 char) not null,
	gd_name varchar2(20 char) not null,
	gd_data varchar2(100 char) not null,
	constraint dataroom_upload
		foreign key(gd_gm_id) references gbraucp2_member(gm_id) on delete cascade
);

select * from GBRAUCP2_dataroom;

create sequence GBRAUCP2_dataroom_seq;

drop table gbraucp2_dataroom cascade constraint purge;

drop sequence GBRAUCP2_dataroom_seq;