-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE seckill;
-- 使用数据库
use seckill;
-- 创建秒杀库存表
CREATE TABLE seckill(
seckill_id bigint not null auto_increment comment '商品库存id',
name varchar(120) not null comment '商品名称',
number int Not null comment '库存数量',
start_time timestamp not null comment '秒杀开启时间',
end_time timestamp not null comment '秒杀结束时间',
create_time timestamp  not null default  current_timestamp  comment '创建时间',
primary key(seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
)ENGINE=innoDB auto_increment=1000 default charset=utf8 comment='秒杀库存表';

-- 初始化数据
insert into
  seckill(name,number,start_time,end_time)
values
  ('1000元秒杀iphone6',100,'2018-10-30 00:00:00','2018-11-08 00:00:00'),
('500元秒杀ipad2',200,'2018-10-30 00:00:00','2018-11-08 00:00:00'),
('300元秒杀小米6',400,'2018-10-30 00:00:00','2018-11-08 00:00:00'),
('200元秒杀红米note2',300,'2018-10-30 00:00:00','2018-11-08 00:00:00');

-- 秒杀成功明细表
-- 用户登录认证相关的信息
create table success_killed(
 seckill_id bigint not null comment '秒杀商品id',
 user_phone bigint not null comment '用户手机号',
state tinyint not null default  -1 comment '状态标识：-1:无效 0:成功 1:已付款',
create_time timestamp  not null DEFAULT CURRENT_TIMESTAMP comment '创建时间',
primary key(seckill_id,user_phone), /*联合主键*/
key idx_create_time(create_time)
)ENGINE=innoDB default charset=utf8 comment='秒杀成功明细表'