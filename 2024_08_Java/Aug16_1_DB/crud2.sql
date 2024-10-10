-- 설계(이게 중요함 ㅇㅇ)
-- RDBMS(Relational DBMS : 관계형 DB) -> MairaDB, MySQL, OracleDB
-- 테이블을 나눠서 디자인하고, 테이블간의 관계를 중심으로 조회

-- DB 모델링
-- 1) 주제별로 나눠서 테이블 만들기
-- 2) primary key 생성

-- 요식업 프렌차이즈

-- 홍길동, 1999-01-01, 수원
-- 김밥천국, 종로점, 종로구123, 10테이블
-- 야채김밥, 4000원, 식사류

-- 김길동, 2000-02-03, 안양
-- 우동천국, 강남점, 강남구456, 7테이블
-- 튀김우동, 5000, 식사류

create sequence aug16_seq;

-- 운영 정보
insert into aug16_information values(aug16_seq.nextval, 1,9);
create table aug16_information (
	i_no varchar(2) primary key, -- 운영 번호
	i_c_no number(2) not null, -- 사장님 번호
	i_r_no number(2) not null -- 매장 번호
);

-- 사장님 정보
insert into aug16_ceo values (aug16_seq.nextval, '김공주', to_date('19940528', 'YYYYMMDD'), '서울');
create table aug16_ceo (
	c_no varchar(2) primary key, -- 사장님 번호
	c_name varchar(10 char) not null, -- 사장님 이름
	c_birthday date not null, -- 사장님 생일
	c_addres varchar(10 char) not null -- 사장님 집
);

-- 식당 정보
insert into aug16_restaurant values (aug16_seq.nextval, '우동천국', '광진점', '광진구789', 11);
create table aug16_restaurant (
	r_no varchar(4) primary key, -- 식당 번호
	r_name varchar(10 char) not null, -- 식당 이름
	r_jijum varchar(10 char) not null, -- 식당 지점
	r_address varchar(40 char) not null, -- 식당 주소
	r_table number(2) not null -- 식당 테이블 수
);

-- 메뉴 정보
insert into aug16_menu values (aug16_seq.nextval, '막걸리', 5000, '주류', 10);
create table aug16_menu (
	m_no varchar(2) not null, -- 메뉴 번호
	m_name varchar(10 char) not null, -- 메뉴 이름
	m_price number(5) not null, -- 메뉴 가격
	m_cate varchar(10 char) not null, -- 메뉴 분류
	m_r_no number(2) primary key -- 매장번호 (매장별로 파는 메뉴의 가격이 다를수 있음)
);

select * from aug16_information;
select * from aug16_ceo;
select * from aug16_restaurant;
select * from aug16_menu;

select m_name, m_price from aug16_menu;

select avg(m_price) from aug16_menu;

select r_name, r_jijum from AUG16_RESTAURANT where r_table = (select max(r_table) from AUG16_RESTAURANT);

select c_name, c_birthday, c_addres from AUG16_CEO where c_birthday = (select max(c_birthday) from AUG16_CEO); -- 생일 max는 최연소

-- 김밥천국 종로점의 메뉴 구하기
select m_name, m_price
from aug16_menu 
where m_r_no = (
	select r_no from AUG16_RESTAURANT 
	where r_name = '우동천국' and r_jijum = '종로점'
);

-- 제일 싼 메뉴는 어디가면 먹을 수 잇을까?(주소 구하기)
select r_address -- 주소 구하기
from AUG16_RESTAURANT
where r_no in (
	select m_r_no -- 매장번호 구하기
	from aug16_menu
	where m_price = (
		select min(m_price) from aug16_menu -- 가장 싼 메뉴 구하기
	)
);

-- 최연장자 사장님이 파는 메뉴명과 가격 찾기
select m_name, m_price -- 메뉴명 가격 찾기
from aug16_menu
where m_r_no in (
	select i_r_no -- 식당 번호 찾기
	from aug16_information
	where i_c_no in (
		select c_no -- 사장님 번호 찾기
		from aug16_ceo
		where c_birthday = (
			select min(c_birthday) -- 최연장자 사장님 구하기(생일 min은 최연장자)
			from aug16_ceo
		)
	)
);

commit -- 가끔 안되는 경우를 대비해서 commit 한번 하기
--		하지만 eclipse는 자동 commit임.

select c_name, c_birthday -- 해당하는 사장님의 이름 생일
from aug16_ceo
where c_no in (
	select i_c_no -- 해당하는 매장의 사장님 번호
	from AUG16_INFORMATION
	where i_r_no in (
		select i_r_no -- 해당하는 매장의 번호
		from aug16_menu
		where m_price in (
			select max(m_price) -- 최고가 메뉴 찾기
			from aug16_menu
		)
	)
);