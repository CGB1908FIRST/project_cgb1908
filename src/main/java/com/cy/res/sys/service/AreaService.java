package com.cy.res.sys.service;

import java.util.List;

import com.cy.res.sys.entity.AreaEntity;

/**
 * area的业务层接口
 * @author Administrator
 *
 */
public interface AreaService {
	/**
	 * 查询所有地区信息
	 * @return
	 */
	public List<AreaEntity> findAllArea();
}
