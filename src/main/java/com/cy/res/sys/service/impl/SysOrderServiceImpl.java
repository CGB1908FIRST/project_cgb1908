package com.cy.res.sys.service.impl;

import org.springframework.stereotype.Service;

import com.cy.res.commom.vo.ServiceException;
import com.cy.res.sys.entity.SysOrder;
import com.cy.res.sys.service.SysOrderService;
@Service
public class SysOrderServiceImpl implements SysOrderService{
	private SysOrderService sysOrderService;
	@Override
	public SysOrder selectObjectByUserId(Integer id) {
		//效验参数
		if(id==null)
			throw new ServiceException("id不能为空");
		SysOrder orderData = sysOrderService.selectObjectByUserId(id);
		return orderData;
	}
}
