-- 1) 이클립스로 DB제어
-- 2) 테이블 만들기, 삭제
-- 3) C - insert
-- 4) R - select - ?
-- 5) U - update
-- 6) D - delete
create table aug19_product (
	p_no number(2) primary key,
	p_name varchar(10 char) not null,
	p_price number(6) not null
);

create sequence aug19_product_seq;

insert into aug19_product values(aug19_product_seq.nextval, '책상', 50000);

delete from AUG19_PRODUCT where p_name like '%우%';

select p_name, p_price from aug19_product where p_name like '%피%';

select * from aug19_product;