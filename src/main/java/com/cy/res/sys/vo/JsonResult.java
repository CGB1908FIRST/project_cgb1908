package com.cy.res.sys.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class JsonResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2373111150353974950L;
	
	private int state=1;
	/**表示状态码对象的状态信息 */
	private String message="ok";
	/**表示响应到客户端的具体数据*/
	private Object data;
	public JsonResult(String message) {
		this.message=message;
	}
	
	public JsonResult(Object data) {
		this.data = data;
	}
	
	public JsonResult(Throwable e) {
		this.state=0;
		this.message=e.getMessage();
	}
}	
