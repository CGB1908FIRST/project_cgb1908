package com.cy.res.commom.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Vo对象
 * 设计此对象的目的是封装控制层要响应到客户端的数据.
 *
 */
@Data
@AllArgsConstructor
public class JsonResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7667122523083115731L;
	/**状态码(服务端想想到客户端的状态码)*/
	private int state=1;//1代表ok,0代表error
	/**表示状态码对象的状态信息*/
	private String message="OK";
	/**表示响应到客户端的具体数据*/
	private Object data;
	public JsonResult() {}
	
	public JsonResult(String message){
		this.message=message;
	}
	public JsonResult(Object data) {
		this.data=data;
	}
	public JsonResult(Throwable t) {
		this.state=0;//表示异常
		this.message=t.getMessage();
	}

}
