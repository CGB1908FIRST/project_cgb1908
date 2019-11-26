package com.cy.res.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.res.sys.entity.HxdUser;
@Mapper
public interface HxdUserDao {
	/**用户注册*/
	int insertObject(HxdUser userData);
	
	/**用户注册时判断登录名称是否存在*/
	int findOnebyLoginName(String userLoginName);
	
	/**用户名查找用户记录*/
	HxdUser findOne(String username);
	
	/**匹配加盐密码*/
	HxdUser findOneBySaltPassword(String SaltPassword,Integer userId);
	
	/**用户id更新密码*/
	int updataPsswordById(Integer userId,String saltPassword,String salt);
	
	/**通过用户Id查找用户整条记录*/
	HxdUser findOneById(Integer userId);
	
}
