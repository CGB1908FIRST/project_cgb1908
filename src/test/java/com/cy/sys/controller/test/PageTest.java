package com.cy.sys.controller.test;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.res.sys.dao.ProductDao;
import com.cy.res.sys.entity.ProductEntity;

@SpringBootTest
public class PageTest {
	@Autowired
	ProductDao productDao;
	@Test
	public void test() {
		int row = productDao.findRowCount(null);
		System.out.println(row);
		
		List<ProductEntity> findPageObject = productDao.findPageObject(2, 0, null);
		System.out.println(findPageObject);
	}
}
