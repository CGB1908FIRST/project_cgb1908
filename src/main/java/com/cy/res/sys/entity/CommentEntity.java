package com.cy.res.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;



/**这是一个商品评价实体类，用来封装商品评价信息。
 * @author xiezhonghuai
 */
@Data
public class CommentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -279034379740248483L;
	/*评价id*/
	private Integer commentId; 
	/*评价内容*/
	private String commentContent; 
	/*评分*/
	private Double commentCore; 
	/*评价时间*/
	private Date commentDate; 
	/*外键关联商品id*/
	private Integer productId; 
	/*外键关联用户id*/
	private Integer userId; 
	/*创建时间*/
	private Date createdTime;  
	/*修改时间*/
	private Date modifiedTime;  
	/*创建人*/
	private String createdUser; 
	/*修改人*/
	private String modifiedUser;  
}

