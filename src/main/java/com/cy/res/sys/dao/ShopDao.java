package com.cy.res.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.res.sys.entity.ShopInfo;

@Mapper
public interface ShopDao {
	//根据用户id查找商店信息
	public List<ShopInfo> findShopInfoByMemberId(Integer memberId);
	
	//更新商店信息
	public int updateShopInfo(ShopInfo shopInfo);
}
