-- 创建数据库
use information_schema;
create database db_test default charset utf8mb4 collate utf8mb4_general_ci;
use db_test;

-- 演示用表
-- 用户表=========================================================
drop table if exists tb_user;

create table tb_user
(
  uid integer auto_increment primary key not null comment '主键',
  username varchar(20) unique not null comment '登录用户名',
  password varchar(50) not null comment '登录密码',
  nickname varchar(50) not null comment '昵称',
  enable enum('y','n') default 'y' not null comment '是否启用',
  lastupdate timestamp default now() not null comment '注册时间'
)comment '用户信息表';

insert into tb_user(username,password,nickname) values('admin','admin','内置管理员');
insert into tb_user(username,password,nickname) values('user','user','内置用户');

select * from tb_user;