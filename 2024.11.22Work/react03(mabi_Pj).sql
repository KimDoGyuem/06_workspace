create table mabi_board_member(
	id char(20) primary key,
    pw char(20) not null
);
select * from mabi_board_member;

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
drop table mabi_character_list;
