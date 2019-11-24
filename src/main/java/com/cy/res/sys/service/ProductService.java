package com.cy.res.sys.service;

import java.util.List;

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

	int insert(ProductEntity entity);

		
	}
