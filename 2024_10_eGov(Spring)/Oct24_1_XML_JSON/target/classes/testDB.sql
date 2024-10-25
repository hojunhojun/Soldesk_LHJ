create table oct24_snack (
	s_title varchar2(10 char) primary key,
	s_genre varchar2(10 char) not null,
	s_price number(6) not null
);

drop table oct24_book cascade constraint purge;

select * from oct24_snack;

delete from OCT24_SNACK where s_title = '포카리스웨트';

insert into oct24_snack values ('썬칩', '짠맛', 1500);

create table oct25_drink (
	d_title varchar2(10 char) primary key,
	d_genre varchar2(10 char) not null,
	d_price number(6) not null
);

select * from oct25_drink;

insert into OCT25_drink values ('미닛메이드포도', '과일음료', 2200);