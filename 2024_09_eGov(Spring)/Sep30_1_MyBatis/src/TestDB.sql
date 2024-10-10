-- eGovFramework 버그
-- 		이클립스 껏다키면 DB툴 안됨
-- 		켜기전에 워크스페이스가서 ~~~sqltools.result폴더 삭제 (bat로 자동화)
--		-> 이클립스 ON
create table sep30_product(
	p_name varchar2(10 char) primary key,
	p_price number(5) not null
);

insert into sep30_product values('마이크', 20000);
insert into sep30_product values('볼펜', 2000);
insert into sep30_product values('샤프', 2000);
insert into sep30_product values('샤프심', 1000);
insert into sep30_product values('연필', 1000);
insert into sep30_product values('지우개', 1000);
insert into sep30_product values('키보드', 20000);
insert into sep30_product values('썬키스트', 1500);

select * from sep30_product;