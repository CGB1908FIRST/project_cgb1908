package com.cy.res.sys.service.impl;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.res.sys.dao.ShopDao;
import com.cy.res.sys.entity.ShopInfo;
import com.cy.res.sys.service.ShopInfoService;
@Service
public class ShopInfoServiceImpl implements ShopInfoService {
	
	@Autowired
	ShopDao shopDao;
	@Override
	public List<ShopInfo> findShopInfoByMemberId(Integer memberId) {
		if (memberId==null) {
			throw new IllegalArgumentException("用户id为空");
		}
		List<ShopInfo> shopInfo = shopDao.findShopInfoByMemberId(memberId);
		return shopInfo;
	}
	
	@Override
	public int updateShopInfo(ShopInfo shopInfo) {
		int rows = shopDao.updateShopInfo(shopInfo);
		if (rows == 0) {
			throw new RuntimeException("该用户已经不存在");
		}
		return rows;
	}

}
