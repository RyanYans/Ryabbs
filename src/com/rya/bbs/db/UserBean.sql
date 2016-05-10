create database bbs;
use bbs; 
create table USER(
 	USERNAME varchar(20) primary key,
 	PASSWORD varchar(20),
 	BIRTHDAY date,
 	EMAIL    varchar(50)
 );