drop table oct10_menu cascade constraint purge;

create table oct10_menu(
	m_no number(3) primary key,
	m_name varchar2(10 char) not null,
	m_price number(5) not null
);

create sequence oct10_menu_seq;

select * from OCT10_MENU;