package com.cy.res.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.res.commom.vo.JsonResult;
import com.cy.res.sys.service.SysOrderService;

@RestController
@RequestMapping("/order/")
public class SysOrderController {
	@Autowired
	private SysOrderService sysOrderService;
	
	public JsonResult doSelectObject(Integer id) {
		sysOrderService.selectObjectByUserId(id);
		return new JsonResult("select ok");
		
	}
	@RequestMapping("toPay")
	public JsonResult paySuccess(HttpServletRequest request) {
		sysOrderService.paySuccessInsert(request);
		return new JsonResult("pay ok");
	}

}
