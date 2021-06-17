--    h2-schame.sql
drop table if exists users ;

-- 创建表
create table users
(
    id int  primary key auto_increment,
    name varchar(20) not null unique,
    password varchar(100) not null,
    email varchar(100) not null unique,
    createdAt long not null
);