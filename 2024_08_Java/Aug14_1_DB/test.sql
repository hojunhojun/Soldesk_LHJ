-- 주석다는법

-- 이클립스에서는 관리자쪽 기능이 안됨(개발자 기능만됨)
-- sqlplus라는 프로그램의 기능은 Eclipse에서는 안됨.

-- 여러줄 실행 -> 블록지정(덮기 : 선택 느낌?) -> alt + x
CREATE TABLE student2(
	name char,
	age int
); -- 가독성을 위한 줄 분배

-- 한줄 실행 : 블록지정 안하고 그 줄 어딘가에 커서 놓고 Alt + s
select * from student2; -- 조회용