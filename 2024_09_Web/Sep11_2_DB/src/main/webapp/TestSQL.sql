-- DBA의 작업영역 : sqlplus
-- create table : DBA의 업무 -> 근데...?

-- varchar2 vs char
-- 10char vs 10

-- 학생 까먹 -> 찾아보셈
create table sep11_product(
	p_no number(3) primary key,
	p_name varchar(10 char) not null,
	p_price number(6) not null
);

create sequence sep11_product_seq;

insert into SEP11_PRODUCT
values(sep11_product_seq.nextval, '테스트', 0);

select * from sep11_product;

select * from (select rownum as rn, p_name, p_price from (select p_name, p_price from sep11_product order by p_name)) where rn >= ? and rn <=?