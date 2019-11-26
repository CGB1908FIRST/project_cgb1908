package com.cy.res.sys.utils;

import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;

public class SimpleHashCode {
	public static String hex(String password,String salt) {
		SimpleHash sh = new SimpleHash(
				"MD5",//algorithmName 算法
				password,//原密码
				salt, //盐值
				1);
		String hex = sh.toHex();
		return hex;
	}
	public static String salt() {
		String salt=UUID.randomUUID().toString();//获取新盐值
		return salt;
	}
}
