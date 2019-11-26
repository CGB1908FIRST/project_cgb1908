package com.cy.res.sys.service.impl.realm;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cy.res.sys.dao.HxdUserDao;
import com.cy.res.sys.entity.HxdUser;
@Service
public class ShiroUserRealm  extends AuthorizingRealm{
	private HxdUserDao hxdUserDao;
	/**
	 * 设置凭证匹配器(与用户添加操作使用相同的加密算法)
	 */
//	@Override
//	public void setCredentialsMatcher(
//	    CredentialsMatcher credentialsMatcher) {
//		//构建凭证匹配对象
//		HashedCredentialsMatcher cMatcher=
//		new HashedCredentialsMatcher();
//		//设置加密算法
//		cMatcher.setHashAlgorithmName("MD5");
//		//设置加密次数
//		cMatcher.setHashIterations(1);
//		super.setCredentialsMatcher(cMatcher);
//	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.获取用户名(用户页面输入)
		UsernamePasswordToken upToken=(UsernamePasswordToken)token;
		String username=upToken.getUsername();
		HxdUser user= hxdUserDao.findOne(username);
		if(user==null)
			throw new UnknownAccountException();
		ByteSource credentialsSalt=ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(
				user,//principal (身份)
				user.getUserPassword(),//hashedCredentials
				credentialsSalt, //credentialsSalt
				getName());//realName
		return info;
	}
}