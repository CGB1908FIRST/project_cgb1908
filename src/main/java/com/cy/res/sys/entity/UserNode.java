package com.cy.res.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserNode implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -1187550882319828773L;
	private String sixNum;
	private Date nodeSendTime;
}
