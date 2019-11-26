DROP DATABASE if exists restaurant ;
CREATE DATABASE restaurant default character set 'utf8';
use restaurant;
--�����
DROP TABLE IF EXISTS area;
	create table area(
		area_id int(11) primary key auto_increment,
		area_name varchar(20) DEFAULT NULL,
		createdTime datetime DEFAULT NULL COMMENT '����ʱ��',
	  	modifiedTime datetime DEFAULT NULL COMMENT '�޸�ʱ��',
	  	createdUser varchar(20) DEFAULT NULL COMMENT '�����û�',
	  	modifiedUser varchar(20) DEFAULT NULL COMMENT '�޸��û�'
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--��Զ��
DROP TABLE IF EXISTS category;
	create table category(
		category_id int(11) primary key auto_increment,
		category_name varchar(20) DEFAULT NULL,
		createdTime datetime DEFAULT NULL COMMENT '����ʱ��',
	  	modifiedTime datetime DEFAULT NULL COMMENT '�޸�ʱ��',
	  	createdUser varchar(20) DEFAULT NULL COMMENT '�����û�',
	  	modifiedUser varchar(20) DEFAULT NULL COMMENT '�޸��û�'
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
--������
DROP TABLE IF EXISTS user;

	create table user(
		user_id int(11) primary key auto_increment,
		user_login_name varchar(20) DEFAULT NULL,
		user_password varchar(20) DEFAULT NULL,
		user_phone varchar(20) DEFAULT NULL,
		salt varchar(20) DEFAULT NULL,
		user_address varchar(40) DEFAULT NULL,
		user_create_time datetime DEFAULT NULL,
		createdTime datetime DEFAULT NULL COMMENT 'ע��ʱ��',
	  	modifiedTime datetime DEFAULT NULL COMMENT '�޸�ʱ��',
	  	createdUser varchar(20) DEFAULT NULL COMMENT '�����û�'
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
--������
DROP TABLE IF EXISTS comment;
	create table comment(
		comment_id int(11) primary key auto_increment,
		comment_content text DEFAULT NULL,
		comment_core float(11) NOT NULL,
		comment_date datetime DEFAULT NULL,
		product_id int(11) NOT NULL,
		user_id int(11) NOT NULL,
		createdTime datetime DEFAULT NULL COMMENT '����ʱ��',
	  	modifiedTime datetime DEFAULT NULL COMMENT '�޸�ʱ��',
	  	createdUser varchar(20) DEFAULT NULL COMMENT '�����û�',
	  	modifiedUser varchar(20) DEFAULT NULL COMMENT '�޸��û�',
		foreign key(user_id) references user(user_id)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
--�޻�
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
		createdTime datetime DEFAULT NULL COMMENT '����ʱ��',
	  	modifiedTime datetime DEFAULT NULL COMMENT '�޸�ʱ��',
	  	createdUser varchar(20) DEFAULT NULL COMMENT '�����û�',
	  	modifiedUser varchar(20) DEFAULT NULL COMMENT '�޸��û�',
		foreign key(area_id) references area(area_id)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
--л�һ�
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
		createdTime datetime DEFAULT NULL COMMENT '����ʱ��',
	  	modifiedTime datetime DEFAULT NULL COMMENT '�޸�ʱ��',
	  	createdUser varchar(20) DEFAULT NULL COMMENT '�����û�',
	  	modifiedUser varchar(20) DEFAULT NULL COMMENT '�޸��û�',
		foreign key(user_id) references user(user_id)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
--������
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
		createdTime datetime DEFAULT NULL COMMENT '����ʱ��',
	  	modifiedTime datetime DEFAULT NULL COMMENT '�޸�ʱ��',
	  	createdUser varchar(20) DEFAULT NULL COMMENT '�����û�',
	  	modifiedUser varchar(20) DEFAULT NULL COMMENT '�޸��û�',
		foreign key(category_id) references category(category_id),
		foreign key(member_id) references member(member_id)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
insert into area values(NULL,'����',now(),now(),'������1','�޸���1');
insert into area values(NULL,'��ɽ',now(),now(),'������2','�޸���2');	
insert into area values(NULL,'�ع�',now(),now(),'������3','�޸���3');
insert into member values(null,'����','13435668621','123451','�ϼ���1','��خԱ�ڵ�����1','�̵�ͼƬ��ַ1','�̵���Ϣ1','1',NOW(),NOW(),'�����û�1','�޸��û�1');
insert into member values(null,'����','13435668622','123452','�ϼ���2','��خԱ�ڵ�����2','�̵�ͼƬ��ַ2','�̵���Ϣ1','1',NOW(),NOW(),'�����û�2','�޸��û�2');
insert into member values(null,'����','13435668623','123453','�ϼ���3','��خԱ�ڵ�����3','�̵�ͼƬ��ַ3','�̵���Ϣ1','1',NOW(),NOW(),'�����û�3','�޸��û�3');
insert into member values(null,'����','13435668624','123454','�ϼ���4','��خԱ�ڵ�����4','�̵�ͼƬ��ַ4','�̵���Ϣ1','1',NOW(),NOW(),'�����û�4','�޸��û�4');
insert into member values(null,'С��','13435668625','123455','�ϼ���5','��خԱ�ڵ�����5','�̵�ͼƬ��ַ5','�̵���Ϣ1','1',NOW(),NOW(),'�����û�5','�޸��û�5');
insert into category values(null,'С��',null,null,'test','test');
insert into category values(null,'����',null,null,'test','test');
insert into category values(null,'�в�',null,null,'test','test');
insert into category values(null,'���',null,null,'test','test');
insert into product values(null,'���ɱ�','���ɱ�',5.8,20,4.5,4.5,'image/rousong',1,1,NOW(),NOW(),'�����û�1','�޸��û�1');
insert into product values(null,'����','����',10.8,25,9.0,4.0,'image/chaofan',1,1,NOW(),NOW(),'�����û�1','�޸��û�1');

insert into product values(null,'����','С����',3.8,23,8.0,5.0,'image/chaofan',1,1,NOW(),NOW(),'�����û�1','�޸��û�1');