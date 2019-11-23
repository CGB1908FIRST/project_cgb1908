package com.cy.res.sys.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.res.sys.entity.UserNode;
import com.cy.res.sys.service.impl.ServiceException;
import com.cy.res.sys.service.impl.realm.HxdUserNoteMsg;
import com.cy.res.sys.vo.JsonResult;


@Controller
@RequestMapping("/msg/")
public class UtilController {
	@Autowired
	private HxdUserNoteMsg hxdUserNoteMsg;
	@RequestMapping("send")
	public JsonResult dosend(String mobile, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		UserNode node = new UserNode();
		node.setNodeSendTime(new Date());
		try {
			node.setSixNum(hxdUserNoteMsg.SendMsg(mobile));
		} catch (Exception e) {
			new ServiceException("短信发送出错");
		}
		return new JsonResult("发送成功");
	}
}
