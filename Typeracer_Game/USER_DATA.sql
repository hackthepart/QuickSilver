
drop database if exists typerace;
create database typerace;
use typerace;
create table user
(
User_Name varchar(30),
Accuracy double,
Errors int,
Speed double
);
insert into user values('Anuj',87.0,5,0.37);


