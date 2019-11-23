package com.cy.res.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.res.sys.dao.AreaDao;
import com.cy.res.sys.entity.AreaEntity;
import com.cy.res.sys.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaDao areaDao; 
	@Override
	public List<AreaEntity> findAllArea() {
		return areaDao.findAllArea();
	}

}
