package com.cy.res.common.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 设计此对象的目的是封装控制层响应到客户端的数据
 * @author xukeqing
 *
 */
@Data
public class JsonResult implements Serializable{
	private static final long serialVersionUID = 1L;
	/**状态码*/
	private int state=1;//1表示SUCCESS,0表示ERROR
	/**状态信息*/
	private String message="ok";
	/**表示响应到客户端的正确数据*/
	private Object data;
	public JsonResult() {}
	public JsonResult(String message){
		this.message=message;
	}
	/**一般查询时调用，封装查询结果*/
	public JsonResult(Object data) {
		this.data=data;
	}
	/**出现异常时时调用*/
	public JsonResult(Throwable t){
		this.state=0;
		this.message=t.getMessage();
	}

}
