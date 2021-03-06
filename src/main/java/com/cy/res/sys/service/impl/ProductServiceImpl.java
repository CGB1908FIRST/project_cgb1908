package com.cy.res.sys.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.res.common.vo.PageObject;
import com.cy.res.sys.dao.ProductDao;
import com.cy.res.sys.entity.FindProductEntity;
import com.cy.res.sys.entity.ProductEntity;
import com.cy.res.sys.service.ProductService;

/**
 * product业务层类用于处理product相关业务
 * 
 * @author xukeqing
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<ProductEntity> findAllProduct(FindProductEntity findProductEntity) {
		List<ProductEntity> productList = new ArrayList<ProductEntity>();
		// 处理查询条件
		Integer areaValue = findProductEntity.getAreaValue();
		ProductEntity[] productArray = {};
		// 根据areaId查询所属商店的id
		Integer[] memberIds = productDao.findMemberIdByAreaId(areaValue);
		if (memberIds.length != 0) {
			Integer categoryValue = findProductEntity.getCategoryValue();
			String orderValue = findProductEntity.getOrderValue();
			// 1调用数据层查询所有产品信息
			productArray = productDao.findAllProduct(memberIds, categoryValue);
			// 2根据页面传入的参数按照销量或者现价或者评分进行排序
			Arrays.sort(productArray, new Comparator<ProductEntity>() {
				@Override
				public int compare(ProductEntity o1, ProductEntity o2) {
					int result = 0;
					switch (orderValue) {
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
		}
		// 3将array装换成list返回给控制层
		productList = Arrays.asList(productArray);
		return productList;
	}

	/**
	 * 通过商品id删除信息
	 * 
	 * @author liuhaibo
	 */
	@Override
	public int doDeleteObject(Integer id) {
		// 1.合法性验证
		if (id == null || id <= 0)
			throw new ServiceException("数据不合法,id=" + id);
		// 2.3执行删除操作
		int rows = productDao.deleteObject(id);
		if (rows == 0)
			throw new ServiceException("此信息可能已经不存在");
		return rows;
	}

	/**
	 * 添加商品信息
	 * 
	 * @author liuhaibo
	 */

	@Override
	public List<ProductEntity> findProductByMemberId(Integer memberId) {
		return productDao.findProductByMemberId(memberId);

	}

	@Override
	public ProductEntity findProductById(Integer productId) {
		return productDao.findProductById(productId);
	}
	/**
	 * 邹 新增商品信息
	 */
	@Override
	public int productInsert(ProductEntity entity) {
		if (entity.getProductName() == null) {
			throw new ServiceException("请输入内容");
		}
		int row = productDao.insertProduct(entity);
		return row;
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageObject<ProductEntity> findPageObject(Integer memberId, Integer pageCurrent) {
		if (pageCurrent == null || pageCurrent < 1) {
			throw new IllegalArgumentException("当前页码不正确");
		}
		// 查询总记录数
		int rowCount = productDao.findRowCount(memberId);
		if (rowCount == 0) {
			throw new ServiceException("当前记录可能已经不存在");
		}
		// 定义页面大小
		int pageSize = 6;
		// 计算开始页码
		int startIndex = (pageCurrent - 1) * pageSize;
		List<ProductEntity> records = productDao.findPageObject(pageSize, startIndex, memberId);

		return new PageObject<>(records, rowCount, pageCurrent, pageSize);
	}
	
	@Override
	public int updateProduct(ProductEntity entity) {
		int row = productDao.updateProduct(entity);
		return row;
	}

}
