package com.cy.res.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.res.sys.dao.CategoryDao;
import com.cy.res.sys.entity.CategoryEntity;
import com.cy.res.sys.service.CategoryService;
/**
 * 商品分类的业务层实现类
 * @author xukeqing
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	@Override
	public List<CategoryEntity> findAllCategory() {
		return categoryDao.findAllCategory();
	}

}
