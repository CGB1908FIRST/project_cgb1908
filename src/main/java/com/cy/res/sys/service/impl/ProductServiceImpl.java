package com.cy.res.sys.service.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cy.res.sys.dao.ProductDao;
import com.cy.res.sys.entity.ProductEntity;
import com.cy.res.sys.service.ProductService;
/**
 * product业务层类用于处理product相关业务
 * @author xukeqing
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Override
	public List<ProductEntity> findAllProduct(String colnum) {
		//1调用数据层查询所有产品信息
		ProductEntity[] productArray = productDao.findAllProduct();
		//2根据页面传入的参数按照销量或者现价或者评分进行排序
		Arrays.sort(productArray,new Comparator<ProductEntity>() {
			@Override
			public int compare(ProductEntity o1, ProductEntity o2) {
				int result =0;
				switch(colnum) {
				case "productSellNum":
					result = o2.getProductSellNum().compareTo(o1.getProductSellNum());
					break;
				case "productCurrentPrize":
					result = o1.getProductCurrentPrize().compareTo(o2.getProductCurrentPrize());
					break;
				default:
					result = o2.getProductCore().compareTo(o1.getProductCore());
				}
				return result;
			}
		});
		//3将array装换成list返回给控制层
		List<ProductEntity> productList = Arrays.asList(productArray);
		return productList;
	}
	/**
	 * 通过商品id删除信息
	 * @author liuhaibo
	 */
	@Override
	public int doDeleteObject(Integer id) {
		//1.合法性验证
				if(id==null||id<=0)
				throw new ServiceException("数据不合法,id="+id);
				//2.3执行删除操作
				int rows=productDao.deleteObject(id);
				if(rows==0)
				throw new ServiceException("此信息可能已经不存在");
				return rows;
	}
/**
 * 添加商品信息
 * @author liuhaibo
 */
	@Override
	public int insert(ProductEntity entity) {
	
		return 0;
		
	}
	}

