DROP DATABASE if exists restaurant ;
CREATE DATABASE restaurant default character set 'utf8';
use restaurant;
--许克清
DROP TABLE IF EXISTS area;
	create table area(
		area_id int(11) primary key auto_increment,
		area_name varchar(20) DEFAULT NULL,
		createdTime datetime DEFAULT NULL COMMENT '创建时间',
	  	modifiedTime datetime DEFAULT NULL COMMENT '修改时间',
	  	createdUser varchar(20) DEFAULT NULL COMMENT '创建用户',
	  	modifiedUser varchar(20) DEFAULT NULL COMMENT '修改用户'
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--邹远文
DROP TABLE IF EXISTS category;
	create table category(
		category_id int(11) primary key auto_increment,
		category_name varchar(20) DEFAULT NULL,
		createdTime datetime DEFAULT NULL COMMENT '创建时间',
	  	modifiedTime datetime DEFAULT NULL COMMENT '修改时间',
	  	createdUser varchar(20) DEFAULT NULL COMMENT '创建用户',
	  	modifiedUser varchar(20) DEFAULT NULL COMMENT '修改用户'
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
--黎振宇
DROP TABLE IF EXISTS user;

	create table user(
		user_id int(11) primary key auto_increment,
		user_login_name varchar(20) DEFAULT NULL,
		user_password varchar(20) DEFAULT NULL,
		user_phone varchar(20) DEFAULT NULL,
		salt varchar(20) DEFAULT NULL,
		user_address varchar(40) DEFAULT NULL,
		user_create_time datetime DEFAULT NULL,
		createdTime datetime DEFAULT NULL COMMENT '注册时间',
	  	modifiedTime datetime DEFAULT NULL COMMENT '修改时间',
	  	createdUser varchar(20) DEFAULT NULL COMMENT '创建用户'
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
--陈延林
DROP TABLE IF EXISTS comment;
	create table comment(
		comment_id int(11) primary key auto_increment,
		comment_content text DEFAULT NULL,
		comment_core float(11) NOT NULL,
		comment_date datetime DEFAULT NULL,
		product_id int(11) NOT NULL,
		user_id int(11) NOT NULL,
		createdTime datetime DEFAULT NULL COMMENT '创建时间',
	  	modifiedTime datetime DEFAULT NULL COMMENT '修改时间',
	  	createdUser varchar(20) DEFAULT NULL COMMENT '创建用户',
	  	modifiedUser varchar(20) DEFAULT NULL COMMENT '修改用户',
		foreign key(user_id) references user(user_id)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
--邹辉
DROP TABLE IF EXISTS member;
	create table member(
		member_id int(11) primary key auto_increment,
		member_name varchar(20) DEFAULT NULL,
		member_phone varchar(20) DEFAULT NULL,
		member_password varchar(20) DEFAULT NULL,
		shop_name varchar(20) DEFAULT NULL,
		shop_address varchar(20) DEFAULT NULL,
		shop_img_url varchar(20) DEFAULT NULL,
		shop_message varchar(20) DEFAULT NULL,
		area_id int(11) NOT NULL,
		createdTime datetime DEFAULT NULL COMMENT '创建时间',
	  	modifiedTime datetime DEFAULT NULL COMMENT '修改时间',
	  	createdUser varchar(20) DEFAULT NULL COMMENT '创建用户',
	  	modifiedUser varchar(20) DEFAULT NULL COMMENT '修改用户',
		foreign key(area_id) references area(area_id)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
--谢忠怀
DROP TABLE IF EXISTS rorder;
	create table rorder(
		order_id int(11) primary key auto_increment,
		order_num varchar(20) DEFAULT NULL,
		order_price float(11) NOT NULL,
		order_is_comment char(1) NOT NULL,
		order_date datetime DEFAULT NULL,
		product_id int NOT NULL,
		product_name varchar(20) DEFAULT NULL,
		product_price float(11) NOT NULL,
		product_count int(11) NOT NULL,
		member_id int(11) NOT NULL,
		user_id int(11) NOT NULL,
		createdTime datetime DEFAULT NULL COMMENT '创建时间',
	  	modifiedTime datetime DEFAULT NULL COMMENT '修改时间',
	  	createdUser varchar(20) DEFAULT NULL COMMENT '创建用户',
	  	modifiedUser varchar(20) DEFAULT NULL COMMENT '修改用户',
		foreign key(user_id) references user(user_id)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
--刘海波
DROP TABLE IF EXISTS product;
	create table product(
		product_id int(11) primary key auto_increment,
		product_name varchar(20) DEFAULT NULL,
		product_subtitle varchar(20) DEFAULT NULL,
		product_original_prize float NOT NULL,
		product_sell_num int(11) NOT NULL,
		product_core float(11) NOT NULL,
		product_current_prize float NOT NULL,
		product_img_url varchar(20) DEFAULT NULL,
		category_id int(11) NOT NULL,
		member_id int(11) NOT NULL,
		createdTime datetime DEFAULT NULL COMMENT '创建时间',
	  	modifiedTime datetime DEFAULT NULL COMMENT '修改时间',
	  	createdUser varchar(20) DEFAULT NULL COMMENT '创建用户',
	  	modifiedUser varchar(20) DEFAULT NULL COMMENT '修改用户',
		foreign key(category_id) references category(category_id),
		foreign key(member_id) references member(member_id)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
insert into area values(NULL,'广州',now(),now(),'创建人1','修改人1');
insert into area values(NULL,'中山',now(),now(),'创建人2','修改人2');	
insert into area values(NULL,'韶关',now(),now(),'创建人3','修改人3');
insert into member values(null,'张三','13435668621','123451','肯鸡鸡1','番禺员岗地铁口1','商店图片地址1','商店信息1','1',NOW(),NOW(),'创建用户1','修改用户1');
insert into member values(null,'李四','13435668622','123452','肯鸡鸡2','番禺员岗地铁口2','商店图片地址2','商店信息1','1',NOW(),NOW(),'创建用户2','修改用户2');
insert into member values(null,'王五','13435668623','123453','肯鸡鸡3','番禺员岗地铁口3','商店图片地址3','商店信息1','1',NOW(),NOW(),'创建用户3','修改用户3');
insert into member values(null,'赵六','13435668624','123454','肯鸡鸡4','番禺员岗地铁口4','商店图片地址4','商店信息1','1',NOW(),NOW(),'创建用户4','修改用户4');
insert into member values(null,'小张','13435668625','123455','肯鸡鸡5','番禺员岗地铁口5','商店图片地址5','商店信息1','1',NOW(),NOW(),'创建用户5','修改用户5');
insert into category values(null,'小吃',null,null,'test','test');
insert into category values(null,'西餐',null,null,'test','test');
insert into category values(null,'中餐',null,null,'test','test');
insert into category values(null,'甜点',null,null,'test','test');
insert into product values(null,'肉松饼','肉松饼',5.8,20,4.5,4.5,'image/rousong',1,1,NOW(),NOW(),'创建用户1','修改用户1');
insert into product values(null,'炒饭','炒饭',10.8,25,9.0,4.0,'image/chaofan',1,1,NOW(),NOW(),'创建用户1','修改用户1');

insert into product values(null,'辣条','小辣条',3.8,23,8.0,5.0,'image/chaofan',1,1,NOW(),NOW(),'创建用户1','修改用户1');