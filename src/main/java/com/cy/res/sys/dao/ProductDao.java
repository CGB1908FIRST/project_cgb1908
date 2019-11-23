package com.cy.res.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
	/**
	 * 
	 * product通过id删除商品
	 * @author liuhaibo
	 */
	@Delete("delete from product where product_id=#{id}")
	  int deleteObject(Integer id);
	/**
	 * 添加商品信息
	 */
	int insert(ProductEntity entity); 
}
