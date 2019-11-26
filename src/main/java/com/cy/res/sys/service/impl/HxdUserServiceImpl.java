package com.cy.res.sys.service.impl;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.cy.res.sys.dao.HxdUserDao;
import com.cy.res.sys.entity.HxdUser;
import com.cy.res.sys.service.HxdUserService;
import com.cy.res.sys.service.impl.realm.HxdUserNoteMsg;
import com.cy.res.sys.utils.SimpleHashCode;
@Service
public class HxdUserServiceImpl implements HxdUserService{
	@Autowired
	private HxdUserDao hxdUserDao;
	/**
	 * 注册用户
	 */
	public int insertObject(HxdUser userData,HttpServletRequest request) {
		//验证数据
		if(userData==null)
			throw new ServiceException("user数据空的");
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
		String password = userData.getUserPassword();//获取密码
		String salt = SimpleHashCode.salt();
		String hex = SimpleHashCode.hex(password, salt);
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
		String hex = SimpleHashCode.hex(password, salt);
		Integer id = user.getUserId();
		HxdUser userdata = hxdUserDao.findOneBySaltPassword(hex,id);
		if(userdata==null||StringUtils.isEmpty(userdata))
			throw new ServiceException("账户名或者密码错误");
		return 1;
	}
	/**判断用户是否存在*/
	@Override
	public int findUserByUsername(String username) {
		//校验数据
		if(username==null)
			throw new ServiceException("用户名不能为空呢");
		int loginname = hxdUserDao.findOnebyLoginName(username);
		if(loginname>0)
			throw new ServiceException("该用户名已存在，大人换一个吧");
		return 1;
	}
	@Override
	public int updataPsswordById(String password, String newpassword, Integer userId) {
		//校验数据
		if(password==null)
			throw new ServiceException("获取不到验证身份密码");
		if(newpassword==null)
			throw new ServiceException("获取不到新密码");
		if(userId==null)
			throw new ServiceException("获取不到id");
		
		HxdUser userData = hxdUserDao.findOneById(userId);
		String oldsaltPssword = userData.getUserPassword();
		String oldsalt = userData.getSalt();
		String hex = SimpleHashCode.hex(password, oldsalt);
		if(hex!=oldsaltPssword)
			throw new ServiceException("身份验证失败，请检查密码是否正确");
		String newsalt = SimpleHashCode.salt();
		String newhex = SimpleHashCode.hex(newpassword, newsalt);
		int rows = hxdUserDao.updataPsswordById(userId, newhex, newsalt);
		if(rows==0)
			throw new ServiceException("修改密码失败");
		return rows;
	}
}
