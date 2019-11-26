package com.cy.res.sys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.res.sys.service.impl.ServiceException;
import com.cy.res.sys.service.impl.realm.HxdUserNoteMsg;
import com.cy.res.sys.vo.JsonResult;


@RestController
@RequestMapping("/msg/")
public class UtilController {
	@Autowired
	private HxdUserNoteMsg hxdUserNoteMsg;
	@RequestMapping("send")
	public JsonResult dosend(String mobile, HttpServletRequest request){
		HttpSession session = request.getSession();
		HashMap<Object, Object> CMap = new HashMap<>();
		CMap.put("date", new Date());
		String sixNum = hxdUserNoteMsg.SendMsg(mobile);
		if(sixNum==null||sixNum.isEmpty())
			throw new ServiceException("短信服务异常");
		CMap.put("sixNum", sixNum);
		session.setAttribute("CMap", CMap);
		return new JsonResult("执行成功");
	}
}
