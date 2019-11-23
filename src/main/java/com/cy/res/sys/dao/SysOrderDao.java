package com.cy.res.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.res.sys.entity.SysOrder;
@Mapper
public interface SysOrderDao {
	/**
	 * 查询根据用户Id查询订单
	 * @param id
	 * @return
	 */
	SysOrder selectObjectByUserId(Integer id);
	/**
	 * 更新订单记录
	 * @param entity
	 * @return
	 */
	//int updateObject(SysOrder entity);
	/**
	 * 获取订单记录
	 * @param entity
	 * @return
	 */
	//int insertObject(SysOrder entity);
	
	

}
