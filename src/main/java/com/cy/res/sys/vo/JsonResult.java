package com.cy.res.sys.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * VO对象
 * 设计此对象的目的是封装控制层响应到客户端的数据
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
public class JsonResult implements Serializable{
	private static final long serialVersionUID = 4191044512195686284L;
	/**状态码*/
	private Integer state=1;//1代表OK 0代表error
	/**状态信息*/
	private String message = "ok";
	/**响应到客户端的具体数据*/
	private Object data;
	
	public JsonResult(String message) {
		this.message = message;
	}
	public JsonResult(Object data) {
		this.data = data;
	}
	public JsonResult(Throwable t){
		this.state=0;
		this.message=t.getMessage();
	}
	
}
