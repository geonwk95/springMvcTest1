package com.springMvcTest1;

import lombok.*;

@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
@NoArgsConstructor // 매개변수가 없는 생성자
@Getter @Setter @ToString
public class Test1Dto {
    private long bno;
    private String bcontent;
    private String bwriter;
    private String bdate;

}

/*
drop database if exists test9;
create database test9;
use test9;
create table board(
	bno bigint auto_increment ,
    bcontent text ,
    bwriter varchar(20) ,
    bdate datetime default now() ,
    constraint test9_board_bno_pk primary key( bno )
);
 */