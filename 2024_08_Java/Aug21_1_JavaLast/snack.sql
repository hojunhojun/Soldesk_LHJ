-- 수원에 있는 오리온이라는 회사 직원 100명
-- 에서 만든 초코파이 5000원 500.5g 2024/09/01까지 먹어

-- DB설계 -> 테스트용 데이터 하나 넣어보고
-- RDBMS : 테이블 나눠서 디자인, 테이블간의 관계를 이용해 해결...
-- 1) 테이블 나눠서
-- 2) 테이블간의 관계

create sequence aug21_snack_seq;

create table aug21_company (
	c_name varchar2(10 char) primary key,
	c_addr varchar2(10 char) not null,
	c_emp number(4) not null
);

insert into AUG21_COMPANY values ('오리온', '수원', 100);

create table aug21_snack (
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_price number(5) not null,
	s_weight number(5,1) not null,
	s_exp date not null,
	s_c_name varchar2(10 char) not null,
	constraint snack_maker foreign key(s_c_name) references aug21_company(c_name) on delete cascade 
	-- foreign key 참조값에 없는것을 등록할 수 없음
	-- constraint 제약조건명 foreign key(필드명) references 테이블명 on delete cascade
);

insert into AUG21_SNACK values (AUG21_SNACK_seq.nextval, '초코파이', 5000, 500.5, to_date('20240901', 'YYYYMMDD'), '오리온');

drop table aug21_snack cascade constraint purge;
delete from aug21_company

select * from AUG21_SNACK;
select * from AUG21_COMPANY;

delete from aug21_snack where s_name = '초코파이';

select count(*) from AUG21_SNACK;

select * 
from (
	select rownum as rn, s_no, s_name, s_price, s_weight, s_exp, s_c_name 
	from (
		select * 
		from aug21_snack 
		order by s_name, s_price
	) 
) where rn >= 3 and rn <= 5;