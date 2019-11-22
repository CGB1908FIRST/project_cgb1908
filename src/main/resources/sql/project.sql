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
		user_nick_name varchar(20) DEFAULT NULL,
		user_true_name varchar(20) DEFAULT NULL,
		user_password varchar(20) DEFAULT NULL,
		user_phone varchar(20) DEFAULT NULL,
		salt varchar(20) DEFAULT NULL,
		user_address varchar(40) DEFAULT NULL,
		user_create_time datetime DEFAULT NULL,
		createdTime datetime DEFAULT NULL COMMENT '创建时间',
	  	modifiedTime datetime DEFAULT NULL COMMENT '修改时间',
	  	createdUser varchar(20) DEFAULT NULL COMMENT '创建用户',
	  	modifiedUser varchar(20) DEFAULT NULL COMMENT '修改用户'
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

