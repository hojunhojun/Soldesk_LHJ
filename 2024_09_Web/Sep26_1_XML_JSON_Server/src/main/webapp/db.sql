create table sep26_snack(
	s_name varchar2(10 char) primary key,
	s_price number(5) not null
);

insert into sep26_snack values('새우깡', 2000);
insert into sep26_snack values('양파링', 2300);

select * from sep26_snack;