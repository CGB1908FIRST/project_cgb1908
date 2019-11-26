package com.cy.res.sys.config;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringShiroConfig {
	@Bean   
	public SessionManager sessionManager() {
		 DefaultWebSessionManager sManager=new DefaultWebSessionManager();
		 sManager.setGlobalSessionTimeout(60*60*1000);
		 return sManager;
    }
	//安全管理器
	@Bean
	public SecurityManager securityManager(Realm realm,
			CookieRememberMeManager rememberManager,
			SessionManager sessionManager) {
		DefaultWebSecurityManager sManager=new DefaultWebSecurityManager();
		sManager.setRealm(realm);
		sManager.setRememberMeManager(rememberManager);
		sManager.setSessionManager(sessionManager);
		return sManager;
	}
	
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactory (SecurityManager securityManager) {
		ShiroFilterFactoryBean sfBean= new ShiroFilterFactoryBean();
		sfBean.setSecurityManager(securityManager);
		//定义map指定请求过滤规则(哪些资源允许匿名访问,哪些必须认证访问)
		LinkedHashMap<String,String> map=new LinkedHashMap<>();
		//静态资源允许匿名访问:"anon"
		map.put("/css/**","anon");
		map.put("/fonts/**","anon");
		map.put("/jquery/**","anon");
		map.put("/js/**","anon");
		map.put("/dologin/**","anon");
		map.put("/regist/**","anon");
		map.put("/user/**","anon");
		map.put("/msg/send","anon");
		//除了匿名访问的资源,其它都要认证("authc")后访问
		map.put("/**","user");//authc
		map.put("/doHomeUI/**","authc");
		sfBean.setFilterChainDefinitionMap(map);
		return sfBean;
	}
	@Bean
	public CookieRememberMeManager rememberMeManager() {
		CookieRememberMeManager cManager=
				new CookieRememberMeManager();
		SimpleCookie cookie=new SimpleCookie("rememberMe");
		cookie.setMaxAge(10*60);
		cManager.setCookie(cookie);
		return cManager;
	}
	@Bean //<bean id="" class="">
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
	@Bean
	public SecurityManager securityManager(Realm realm) {
		 DefaultWebSecurityManager sManager=
		 new DefaultWebSecurityManager();
		 sManager.setRealm(realm);
		 return sManager;
	}
}
