package com.cy.res.sys.service.impl;

import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.res.sys.dao.HxdUserDao;
import com.cy.res.sys.entity.HxdUser;
import com.cy.res.sys.entity.UserNode;
import com.cy.res.sys.service.HxdUserService;
import com.cy.res.sys.service.impl.realm.HxdUserNoteMsg;
@Service
public class HxdUserServiceImpl implements HxdUserService{
	@Autowired
	private HxdUserDao hxdUserDao;
//	@Autowired
//	private HxdUserNoteMsg hxdUserNoteMsg; 
	/**
	 * 注册用户
	 */
	public int insertObject(HxdUser userData,HttpServletRequest request) {
		//验证数据
		if(userData==null)
			throw new ServiceException("user数据空的");
//		if(StringUtils.isEmpty(userData.getUserNickName()))
//			throw new ServiceException("昵称啊,(>﹏<)");
		if(StringUtils.isEmpty(userData.getUserPhone()))
			throw new ServiceException("大人，手机号还没填呢(>﹏<)");
		if(StringUtils.isEmpty(userData.getUserLoginName()))
			throw new ServiceException("名字都没有,滚呐,沙雕");
		if(StringUtils.isEmpty(userData.getUserPassword()))
			throw new ServiceException("密码都没有,滚呐,猪头");
		if(StringUtils.isEmpty(userData.getCode()))
			throw new ServiceException("没有验证码,快走开,略略略");
		HashMap<String, Object> note =(HashMap)request.getSession().getAttribute("CMap");
		Object date = note.get("date");
		String sixNum =(String) note.get("sixNum");
		if(!sixNum.equals(userData.getCode()))
			throw new ServiceException("验证码有误，注册失败了(>﹏<)");
		
		//UserNode noteData =(UserNode) request.getAttribute("nodeData");
//		if(userData.getCode()==note.getSixNum())
//			throw new ServiceException("验证码有误，注册失败了(>﹏<)");
		String password = userData.getUserPassword();//获取密码
		String salt=UUID.randomUUID().toString();//获取盐值
		SimpleHash sh=new SimpleHash(//Shiro框架
				"MD5",//algorithmName 算法
				password,//原密码
				salt, //盐值
				1);//hashIterations表示加密次数
		String hex = sh.toHex();//加密后新密码
		userData.setSalt(salt);
		userData.setUserPassword(hex);
		int rows = hxdUserDao.insertObject(userData);
		if(rows<1)
			throw new ServiceException("注册用户失败");
		return rows;
	}
	/**
	 * 判断是否登录
	 */
	@Override
	public int isLogin(String username, String password,Boolean isRemenberMe) {
		//校验数据
		if(username==null)
			throw new ServiceException("获取不到用户名");
		if(password==null)
			throw new ServiceException("获取不到密码");
		//查找用户名记录
		HxdUser user = hxdUserDao.findOne(username);
		if(user==null||StringUtils.isEmpty(user.getUserId()))
			throw new ServiceException("账户名或者密码错误1");
		String salt = user.getSalt();
		SimpleHash sh=new SimpleHash(//Shiro框架
				"MD5",//algorithmName 算法
				password,//原密码
				salt, //盐值
				1);//hashIterations表示加密次数
		
		//验证加盐后密码是否与password相同
		String hex = sh.toHex();
		Integer id = user.getUserId();
		HxdUser userdata = hxdUserDao.findOneBySaltPassword(hex,id);
		if(userdata==null||StringUtils.isEmpty(userdata))
			throw new ServiceException("账户名或者密码错误");
		
		return 1;
	}
	/**判断用户是否存在*/
	@Override
	public int findUserByUsername(String username) {
		if(username==null)
			throw new ServiceException("用户名不能为空呢");
		int loginname = hxdUserDao.findOnebyLoginName(username);
		if(loginname>0)
			throw new ServiceException("该用户名已存在，大人换一个吧");
		return 1;
	}

}
