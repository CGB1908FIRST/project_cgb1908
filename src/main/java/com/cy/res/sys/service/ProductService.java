package com.cy.res.sys.service;

import java.util.List;


import com.cy.res.common.vo.PageObject;
import com.cy.res.sys.entity.FindProductEntity;
import com.cy.res.sys.entity.ProductEntity;



/**
 * product业务层接口
 * @author xukeqing
 *
 */
public interface ProductService {
	
	/**
	 * 查询所有product
	 * @return
	 */
	List<ProductEntity> findAllProduct(FindProductEntity findProductEntity);
      
	/** 
	 * 通过商品id删除信息
	 * @author liuhaibo
	 * @return
	 */
	int doDeleteObject(Integer id);

	/**
	 * 邹
	 * @param entity
	 * @return
	 */
	int productInsert(ProductEntity entity);
	
	/**
	 * 邹
	 * 使用网页端传输过来的用户名和当前页面,实现商品的分页查询分页查询
	 */
	PageObject<ProductEntity> findPageObject(Integer memberId, Integer pageCurrent);
	
	/**
	 * 邹
	 * 更新商品信息
	 */
	//int updateProduct(ProductEntity entity);
	}
