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
	
	@Select("select * from product where member_Id=#{memberId}")
	List<ProductEntity> findProductByMemberId(Integer memberId);
	
	Integer[] findMemberIdByAreaId(Integer areaId);
	/**
	 * 根据条件查询product
	 * @param areaValue
	 * @param categoryValue
	 * @return
	 */
	ProductEntity[] findAllProduct(
			@Param("memberIds") Integer[] memberIds,
			@Param("categoryId") Integer categoryValue
			);
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

	@Select("select * from product where product_Id=#{productId}")
	ProductEntity findProductById(Integer productId); 
}
