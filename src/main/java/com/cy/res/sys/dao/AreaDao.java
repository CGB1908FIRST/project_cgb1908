package com.cy.res.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.res.sys.entity.AreaEntity;

/**
 * 地区的数据层接口
 * @author Administrator
 *
 */
@Mapper
public interface AreaDao {
	/**
	 * 查询所有地区信息
	 * @return
	 */
	@Select("select * from area")
	public List<AreaEntity> findAllArea();
}
