package com.situ.eoa.goods.service;

import java.util.List;

import com.situ.eoa.base.domain.PageData;
import com.situ.eoa.goods.domain.Goods;
import com.situ.eoa.role.domain.Role;

public interface GoodsService {
	Long saveGoods(Goods goods);
	List<Goods>find();
	List<Goods> findByPage(Integer pageNo, Goods searchGoods);
	Goods findGoodsById(Long rowId);
	Long doUpdate(Goods goods);
	Long doDeleteGoods(Long rowId);
	Boolean checkGoodsName(String goodsName);
	PageData buildPageData(Integer pageNo,Goods searchGoods);
}
