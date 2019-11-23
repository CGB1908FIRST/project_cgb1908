package com.cy.res.sys.service;

import com.cy.res.sys.entity.SysOrder;

public interface SysOrderService {
	/**
	 * 使用用户id查询订单表所有记录
	 * @param id
	 * @return
	 */
	SysOrder selectObjectByUserId(Integer id);
}
