package com.cy.res.sys.service;

import java.util.List;

import com.cy.res.sys.entity.ShopInfo;

public interface ShopInfoService {
	//查找商店信息
	public List<ShopInfo> findShopInfoByMemberId(Integer memberId);
	
	//更新商店信息
	public int updateShopInfo(ShopInfo shopinfo);
}
