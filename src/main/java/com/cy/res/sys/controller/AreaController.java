package com.cy.res.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.res.common.vo.JsonResult;
import com.cy.res.sys.entity.AreaEntity;
import com.cy.res.sys.service.AreaService;

@Controller
@RequestMapping("/area/")
@ResponseBody
public class AreaController {

	@Autowired
	private AreaService areaService;
	@RequestMapping("doFindAllArea")
	public JsonResult doFindAllArea(){
		List<AreaEntity> areaList = areaService.findAllArea();
		return new JsonResult(areaList);
	}
}
