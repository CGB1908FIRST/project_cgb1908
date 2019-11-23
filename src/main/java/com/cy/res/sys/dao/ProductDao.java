package com.cy.res.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.res.sys.entity.ProductEntity;

/**
 * product数据层接口
 * @author xukeqing
 *
 */
@Mapper
public interface ProductDao {
	@Select("select * from product order by product_core")
	ProductEntity[] findAllProduct();
}
