select * from AUG14_SNACK;

create table aug16_fruit (
	f_no varchar2(2) primary key,
	f_name varchar2(10 char) not null,
	f_price number(6) not null,
	f_weight number(3, 1) not null,
	f_exp date not null 
);

drop table aug16_fruit cascade constraint purge; -- 테이블 지우기

-- 번호 : 데이터는 아니지만 Primary Key가 필요해서 억지로 추가한거임
--		이걸 사람이 관리해야하나? 자동이었으면 좋겠는데?
--		-> MySQL, MariaDB : auto increment 옵션쓰면 됨
--		-> 하지만 Oracle은? : sequence
-- sequence 만들기
-- create sequence 시퀀스명;
-- Tip) sequence/table은 별개의 존재지만 일반적으로 1 table당 1 sequence로 사용함.
-- 		-> create sequence 테이블명_seq;
create sequence aug16_fruit_seq;

drop sequence aug16_fruit_seq;
-- sequence 사용 : 시퀀스명.nextval
-- insert 실패해도 카운트가 올라감
-- 여러 테이블이 같이 사용 가능함 : 사용 주의
-- 데이터를 삭제하면? 번호가 당겨지나? 에이 그건 아닌데 ㅋㅋ
-- primary key + seq = 정확한 1,2,3,4.....을 원하는 것은 아님.
--------------------------------------------------------
-- 오라클에서 시간 날짜 처리할때
-- 현재 시간, 날짜 사용하고 싶으면 : sysdate 키워드 사용
-- 특정 시간, 날짜 사용하고 싶으면 : to_date('값', '패턴') str -> date로 바꿔줌
--							  ex) YYYY MM DD HH MI SS (시간의 표현 : AM, PM, HH24(★))
--							  ex) to_date('2024-09-01 13:30:00', 'YYYY-MM-DD HH24:MI:SS)
insert into aug16_fruit values(aug16_fruit_seq.nextval, '사과', 30000, 1.5, to_date('2024-09-01 13:30:00', 'YYYY-MM-DD HH24:MI:SS'));
insert into aug16_fruit values(aug16_fruit_seq.nextval, '수박', 40000, 2.1, to_date('2024-09-01 13:00', 'YY-MM-DD HH24:MI'));
insert into aug16_fruit values(aug16_fruit_seq.nextval, '복숭아', 50000, 0.5, to_date('2024-09-03', 'YYYY-MM-DD'));
insert into aug16_fruit values(aug16_fruit_seq.nextval, '딸기', 8000, 1.2, to_date('2024-08-15 13', 'YYYY-MM-DD HH24'));
insert into aug16_fruit values(aug16_fruit_seq.nextval, '수박', 16000, 1.7, to_date('2024-08-16 12:30:00', 'YYYY-MM-DD HH24:MI:SS'));
insert into aug16_fruit values(aug16_fruit_seq.nextval, '키위', 10000, 1.9, to_date('2024-09-29 11:30:00', 'YYYY-MM-DD HH24:MI:SS'));
insert into aug16_fruit values(aug16_fruit_seq.nextval, '멜론', 18000, 0.3, to_date('2024-08-17 11:00:00', 'YYYY-MM-DD HH24:MI:SS'));
insert into aug16_fruit values(aug16_fruit_seq.nextval, '복숭아', 12000, 0.2, to_date('2024-08-18 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
insert into aug16_fruit values(aug16_fruit_seq.nextval, '자두', 19000, 0.1, to_date('2024-08-29 14:30:00', 'YYYY-MM-DD HH24:MI:SS'));
insert into aug16_fruit values(aug16_fruit_seq.nextval, '포도', 10000, 0.8, to_date('2024-09-07 14:00:00', 'YYYY-MM-DD HH24:MI:SS'));

-- R(조회하기)
select * from aug16_fruit;
-- select * from 테이블명;
-- 하지만 과일 이름, 가격(특정 필드, 값)만 필요하다면?
-- -> select 필드명, 필드명, ... from 테이블명;

-- 전체 과일 이름, 유통기한 조회하기
select f_name, f_exp as exp_date from AUG16_FRUIT;
-- -> 필드명이 마음에 들지 않으면 as XXX로 이름 바꿔서 출력 가능

-- 전체 과일 이름, 가격, 할인가 20% 조회하기
select f_name, f_price, f_price * 0.8 as sale_price from AUG16_FRUIT;
-- -> 필드명에 연산자 붙여서 계산 가능

-- 전체 과일 이름, kg당 가격
select f_name, f_price / f_weight as kg_price from AUG16_FRUIT;
-- -> 필드간의 계산도 가능

-- 전체 과일 평균값
select avg(f_price) from AUG16_FRUIT;
-- 통계함수 사용 가능
-- sum, avg, max, min, count, ...

-- 최고가, g당 가격 최저가, 총 과일 수
select max(f_price) as max_price, min(f_price / f_weight) as min_g_price, count(*) from AUG16_FRUIT;

-- 가격이 20000 이상인 과일 이름, 가격
select f_name, f_price from AUG16_FRUIT where f_price >= 20000;
-- 조건문 사용법 : select XXX from XXX where 조건문;

-- 수박 평균가
select avg(f_price) from AUG16_FRUIT where f_name = '수박';

-- 이름에 '수'들어있는거 이름. 가격
select f_name, f_price from AUG16_fruit where f_name like '%수%';
-- 문자열 포함 검색 : 필드명 like '패턴';
--				  ex) '%가' : 가로 끝남 / '가%' : 가로 시작 / '%가' : 가 포함

insert into aug16_fruit values(aug16_fruit_seq.nextval, '테스트', 10000, 0.8, to_date('2024-08-16 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));

-- 유통기한이 2024/08/20 15시 이후인 이름, 유통기한
select f_name, f_exp as exp_date from AUG16_FRUIT where f_exp > to_date('2024/08/20 15', 'YYYY/MM/DD HH24');
-- 날짜 비교시엔 to date함수 이용

-- 내일 먹으면 안되는 과일(유통기한이 오늘까지) 이름, 유통기한
select f_name, f_exp from AUG16_FRUIT where f_exp < to_date(concat(to_char(sysdate, 'YYYYMMDD'), ' 235959'), 'YYYYMMDD HH24MISS');
-- to_char : date -> str / concat : 글자 붙일때 사용
-- 날짜를 문자열로 바꿔서 시간 추가하고 다시 날짜로 바꿔서 유통기한과 비교하기(★)

-- 수박 or 사과 이름, 가격
select f_name, f_price from AUG16_FRUIT where f_name = '수박' or f_name = '사과';
-- SQL은 && || 사용보단 and or의 알파벳으로 적자.

-- 가격이 만원보다 비싸고 2만원보다 싼 과일 가격, 이름
select f_name, f_price from AUG16_FRUIT where f_price > 10000 and f_price < 20000;
-- select f_name, f_price from AUG16_FRUIT where f_price between 10000 and 20000;
-- 위의 문장은 10000과 20000을 포함하므로 탈락

-- 유통기한이 오늘 오후중에 끝나는 이름, 유통기한
select f_name, f_price from AUG16_FRUIT 
where f_exp <= to_date(concat(to_char(sysdate, 'YYYYMMDD'), ' 235959'), 'YYYYMMDD HH24MISS')
and f_exp >= to_date(concat(to_char(sysdate, 'YYYYMMDD'), ' 120000'), 'YYYYMMDD HH24MISS');

-- 최고가 이름, 가격
select f_name, f_price from AUG16_FRUIT where f_price = (select max(f_price) from AUG16_FRUIT);
-- sql문 속에 sql문을 넣는것을 subquery 라고 함

-- 평균가보다 싼거 이름, 가격
select f_name, f_price from AUG16_FRUIT where f_price < (select avg(f_price) from AUG16_FRUIT);