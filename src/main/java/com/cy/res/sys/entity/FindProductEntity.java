package com.cy.res.sys.entity;

import lombok.Data;

/**
 * 用来封装查询product的条件
 * @author xukeqing
 *
 */
@Data
public class FindProductEntity {
	private Integer areaValue;
	private Integer categoryValue;
	private String orderValue;
}
