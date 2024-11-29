create table mabi_board_member(
	id char(20) primary key,
    pw char(20) not null
);
select * from mabi_board_member;

create table mabi_board(
	m_no int primary key auto_increment,
    m_title char(50) not null,
    m_id char(50) not null,
    m_text text not null,
    m_category char(50) not null
);
select * from mabi_board;
insert into mabi_board(m_title,m_id,m_text,m_category) values('제목','id','내용','free');

create table mabi_character_list(
	character_name char(20) not null,
    class_name char(20) not null,
    level int not null,
    offensive_power char(20) not null,
    magic_power char(20) not null,
    additional_damage char(20) not null,
    critical char(20) not null,
    balance char(20) not null,
    unrestricting_Attacks char(20) not null,
    id char(20) not null,
    deployment int not null default 0 
);
select * from mabi_character_list;
drop table tbl_doodle,tbl_test,tbl_test_del,tbl_visitant_count;
