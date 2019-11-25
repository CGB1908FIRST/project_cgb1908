package com.cy.res.sys.service;

import javax.servlet.http.HttpServletRequest;
import com.cy.res.sys.entity.SysOrder;

public interface SysOrderService {
	/**
	 * 使用用户id查询订单表所有记录
	 * @param id
	 * @return
	 */
	SysOrder selectObjectByUserId(Integer id);
	
	void paySuccessInsert(HttpServletRequest request);
}
