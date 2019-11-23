package com.cy.res.sys.config;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringShiroConfig {
//	@Bean
//	public ShiroFilterFactoryBean shiroFilterFactory (SecurityManager securityManager) {
//		
//		ShiroFilterFactoryBean sfBean = new ShiroFilterFactoryBean();
//		sfBean.setSecurityManager(securityManager);
//		sfBean.setLoginUrl("/doLogin");
//		LinkedHashMap<String,String> map=new LinkedHashMap<>();
//		map.put("/bower_components/**","anon");
//		map.put("/build/**","anon");
//		map.put("/dist/**","anon");
//		map.put("/plugins/**","anon");
//		map.put("/user/doLogin","anon");
//		map.put("/doLogout","logout");
//		//除了匿名访问的资源,其它都要认证("authc")后访问
//		map.put("/**","user");//需要认证访问的资源需要写在后面
//		sfBean.setFilterChainDefinitionMap(map);
//		return sfBean;
//	}
}
