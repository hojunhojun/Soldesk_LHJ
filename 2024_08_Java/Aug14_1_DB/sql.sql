-- SQL(Structured Query Language)
-- 		DB를 제어하는 언어
-- 		다양한 DB메이커들이 공용으로 사용하는 언어

-- Oracle
-- 아 학원에서 Oracle했는데,,,, 이건말안됨 ㅋㅋ
-- 대소문자 구별 X -> 대문자로 인식함

-- Java가 어려움.,,? - 변수, 조건문, .... 적재적소에 사용하는 판단(창의성)
-- SQL -> DB 제어용 언어 - 변수?, 조건문? 다없음 -> 적재적소 창의성? 그런거없음 답이 다있음
--	table
--		field, 열(column)
-- 		record, 행(row), data
-----------------------------------------
--	DBP : DB랑 연동된 포로그램 개발
-- 	CRUD : 데이터를 Create, Read, Update, Delete
-----------------------------------------
-- 테이블 만들기
-- 용량
-- 5 : 5bytes
-- OracleDB에서 영어/ 숫자 1글자씩 = 1byte
--				한글 한글자1 = 3bytes 고정사이즈				
-- 				5 char : varchar)15_ = 띄어쓰기를 넣어서라도 무조건용량대로 저장
-- create table 테이블명(
--     필드명 자료형 옵션,
--	   열제목 자료형 옵션
--	   ...
-- );
-- 가격으로 찾으면 : 여러개가 나올수 있음
-- 이름으로 찾으면 : 1개가 나옴
-- 옵션
--		not null : 값 필수
--		primary key : not null + 중복데이터 불허 -> 해당 데이터를 대표하는 값(데이터 찾을때 정확하게 찾아줄 기준값)
--					테이블에는 최소한 하나의 Primary key를 부여하자

-- 그냥 필드명쓰면 SQL문법과 중복될까봐 테이블 첫글자를 필드명에 붙임
-- 자료형(Oracle)
--		글자
--		char(띄어쓰기를 넣어서라도 무노건 용량대로 저장) varchar2보다 빠를것 -> HDD 비효율적, CPU에 효율적
--		-> 자리수가 일정한 상황
--		varchar2(용량보다 적게쓰면 용량을 조절해서 저장) char보다 느릴것, 주로 많이 씀 -> HDD 효율적, CPU에 타격
--		-> 자리수가 일정하지 않은 상황
--		숫자 -> number(용량) / number(5) 정수 5자리 / number(5, 2) : 실수 xxx.xx
--		두 자료형의 가치판단 잘 하기
--		시간/날짜 -> date
--	DB는 하드디스크에 저장됨
create table aug14_snack(
	-- s_name char(5 char) primary key
	s_name varchar2(10 char) primary key,
	s_price number(5) not null
);
-----------------------------------------
-- 테이블 수정 - 기능 자체는 있는데, 실무에서는 거의 못씀 -> 수업안해~
-----------------------------------------
-- 테이블 삭제
-- drop table 테이블명 cascade constraint purge;
drop table aug14_snack cascade constraint purge;
-----------------------------------------
-- 데이터 넣기 : Dreate
-- insert into 테이블명 values(값, 값, ...); -> 순서 맞춰서
insert into AUG14_SNACK values('빼빼로', 2000);
insert into AUG14_SNACK values('새우깡', 3000);
insert into AUG14_SNACK values('양파링', 3500);
insert into AUG14_SNACK values('멘토스', 1000);
insert into AUG14_SNACK values('포카칩', 3500);
insert into AUG14_SNACK(s_price, s_name) values(500, '새콤달콤'); -- 순서 바꾸기 가능(굳이?)
insert into AUG14_SNACK(s_name) values('제크'); -- 특정 필드만 값넣기 가능(굳이?) : 가격을 안넣어서 error
--------------------------------
-- 데이터 조회 - Read
select * from aug14_snack;
--------------------------------

create table aug14_student(
	s_no varchar2(2) primary key,
	s_name varchar2(10 char) not null, -- 동명이인때문에 프라이머리 키 탈락
	s_kor number(3) not null,
	s_eng number(3) not null,
	s_mat number(3) not null
);

drop table aug14_student cascade constraint purge;

insert into AUG14_student values(1, '홍길동', 50, 90, 80);
insert into AUG14_student values(2, '홍길동', 0, 20, 30);

select * from aug14_student;