-- OracleDB
-- C 
-- R
-- U : update

-- update 테이블명
-- set 필드명=값, 필드명=값, ...
-- where 조건식;

-- 야채김밥을 5000원으로 수정
update AUG16_MENU
set m_price=5000
where m_name = '야채김밥';

-- 밥 시리즈 500원 인상(메뉴명에 밥 포함)
update aug16_menu
set m_price = m_price + 500
where m_name like '%밥%';

-- 김밥천국 종로점 전메뉴 10% 인상
update aug16_menu
set m_price = m_price * 1.1
where m_r_no = (
	select r_no
	from AUG16_RESTAURANT
	where r_name = '김밥천국' and r_jijum = '종로';
);

select * from aug16_menu
select * from aug16_restaurant;

-- D : delete

-- delete from 테이블명
-- where 조건식

-- 야채김밥 삭제
delete from aug16_menu
where m_name = '야채김밥';

-- 테이블수 가장 적은 매장 폐업 ( 그러면 삭제된 매장의 메뉴는? : 미리 찾아서 지웠어야함 ㅇㅇ)
delete from aug16_restaurant
where r_table = (
	select min(r_table)
	from aug16_restaurant
);