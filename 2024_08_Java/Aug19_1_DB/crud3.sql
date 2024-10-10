select * from aug16_information;
select * from aug16_ceo;
select * from aug16_restaurant;
select * from aug16_menu;

-- 주소가 종로구 어쩌고인 식당의 메뉴명, 가격
select m_name, m_price from AUG16_MENU
where m_r_no in (
	select r_no 
	from AUG16_RESTAURANT 
	where r_address like '%종로구%'
);

-- 평균보다 비싼 메뉴명, 가격, 식당명, 지점명
select m_name, m_price, r_name, r_jijum
from AUG16_MENU, aug16_restaurant
where r_no = m_r_no and m_price > (
	select avg(m_price)
	from AUG16_MENU
);
-- join : 테이블 여러개를 붙여서....

-- 테이블 수 가장 적은 식당명, 지점명, 사장이름, 생일
select r_name, r_jijum, c_name, c_birthday
from AUG16_INFORMATION, AUG16_RESTAURANT, AUG16_CEO
where c_no = i_c_no and i_r_no = AUG16_RESTAURANT.r_no and r_table = ( -- 이름이 중복되면 테이블명.필드 이런식으로 
	select min(r_table)
	from AUG16_RESTAURANT
);

-- 최연장ㅌ자 사장님의 메뉴명, 가격
select m_name, m_price
from AUG16_CEO, AUG16_INFORMATION, AUG16_MENU
where c_no = i_c_no and i_r_no = m_r_no and c_birthday (
	select min(c_birthday)
	from aug16_ceo
);

-- join vs subquery
-- 일단 모든 경우의 수 다 붙여놓고 where로 필터링
-- 10TB가 hdd에 저장되어잇는데 붙여놓으면 용량이 폭등
-- 이래도 join 쓸거야....?

-- 일단 ~~해놓고 : 변수
-- where로 : if문

-- 테이블이 3개 이상인 매장의 매장명, 지점명, 메뉴명, 가격을 메뉴명 
-- 을 가나다순으로 정렬
select r_name, r_jijum, m_name, m_price
from aug16_restaurant, aug16_menu
where r_no = m_r_no and r_table >=3
order by r_name, m_name desc;
-- 정렬 조건문 (기본적으로 오름차순 -> desc 붙이면 내림차순)
-- order by 필드명, 필드명, 필드명...

-- 식사류를 파는 매장명, 지점명, 주소, 테이블수
-- 테이블 많은 순서 -> 매장명 가나다 -> 지점명 가나다
select r_name, r_jijum, r_address, r_table
from aug16_restaurant
where r_no in (
	select m_r_no
	from aug16_menu
	where m_cate = '식사'
) order by r_table desc , r_name, r_jijum;

-- select 필드명, 필드명 as 별칭, ...(연산자 사용 가능)
-- from 테이블명(subquery 사용가능)
-- where 조건문
-- group by 필드명, 필드명, ...
-- having 조건식		-> group by랑 같이 쓰는거임 ㅇㅇ
-- order by 필드명, 필드명, ...

-- rownum
-- 		select 할때마다 부여되는 가상필드 -> * 랑은 같이 사용 불가
--		oredr by ~~~ 보다 먼저 적용됨
select * -- 2차정렬에서 생긴 rownum을 최종 정렬
from (
	select rownum as rn, m_no, m_name, m_price -- 2차 정렬(rownum 생성)
	from (
		select m_no, m_name, m_price
		from aug16_menu
		order by m_price -- 1차 정렬
	)
) where rownum >=1 and rownum <= 5

-- 메뉴명, 가격
-- 메뉴명 가나다 -> 가격 싼순서
select *
from (
	select rownum as rn, m_name, m_price --rn으로 선언했으니까
	from (
		select m_name, m_price
		from aug16_menu
		order by m_name, m_price
	)
) where rn >= 5 and rn <= 8; -- rn으로 조건걸어야함
-- 페이지 : 한 페이지당 4개씩
-- 1p : 1,2,3,4
-- 2p : 5,6,7,8
-- 3p : 9,10,11,12
-- 페이지번호 2 -> 시작데이터번호 5, 끝데이터번호 8
-- 5~8번 까지만


-- 제일 비싼 메뉴만 빼고
-- 메뉴명, 가격, 사장이름
-- 메뉴명 가나다 -> 가격 싼 순서
-- 3 ~ 5번까지만
select * -- 2차정렬
from (
	select rownum as rn, m_name, m_price, c_name -- rownum 생성
	from (
		select m_name, m_price, c_name -- 1차정렬
		from aug16_ceo, aug16_information, aug16_menu
		where c_no = i_c_no and i_r_no = m_r_no and m_price < ( -- 제일 비싼 메뉴 제외
			select max(m_price)
			from aug16_menu
		)
		order by m_name, m_price
	)
) where rn >= 3 and rn <= 5;

-- 카테고리별 메뉴 평균값 (분석 까라)
select m_cate, avg(m_price)
from aug16_menu
group by m_cate -- 그룹 지어서 통계
order by m_cate; -- 그룹 이름별 정렬

-- 식당별 메뉴 최고가, 최소가
-- 식당명별 가나다순 정렬
select r_name, m_cate, max(m_price), min(m_price)
from aug16_menu, aug16_restaurant
where r_no = m_r_no
group by r_name, m_cate
order by r_name, m_cate;

-- 사장이름별로 -> 카테고리별 메뉴 평균가, 갯수
-- 사장이름별 -> 카테별 가나다
select c_name, m_cate, avg(m_price), count(*)
from aug16_ceo, aug16_menu, aug16_information
where c_no = i_c_no and i_r_no = m_r_no 
group by c_name, m_cate
order by c_name, m_cate;

-- 카테고리별 평균가
-- 카테고리별 가나다순
-- 평균계산할때 가격이 5000 미만인건 빼고 계산해(데이터 필터링)
select m_cate, avg(m_price)
from aug16_menu
where m_price >= 5000
group by m_cate
order by m_cate;

-- 카테고리별 평균가
-- 카테고리별 가나다순
-- 평균계산할때 가격이 5000 미만인건 보여주지마(결과 필터링)
select m_cate, avg(m_price)
from aug16_menu
group by m_cate
having avg(m_price) >= 5000
order by m_cate;

-- 종로구 위치한 매장 / 매장명별, 카테고리별 평균가
-- 매장명 가나다순, 카테고리 가나다순
-- 평균가 3000원 미만인거 빼고
select r_name, m_cate, avg(m_price)
from aug16_restaurant, aug16_menu
where r_no = m_r_no and r_address like '%종로구%'
group by r_name, m_cate
having avg(m_price) >= 3000
order by r_name, m_cate;