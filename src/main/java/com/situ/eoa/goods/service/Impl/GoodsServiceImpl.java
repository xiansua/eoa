package com.situ.eoa.goods.service.Impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.eoa.base.domain.PageData;
import com.situ.eoa.goods.dao.GoodsDao;
import com.situ.eoa.goods.domain.Goods;
import com.situ.eoa.goods.service.GoodsService;
import com.situ.eoa.util.PageUtils;
@Service
public class GoodsServiceImpl implements Serializable,GoodsService{
	private static final long serialVersionUID = 1L;
	@Autowired
	private GoodsDao goodsDao;
	@Override
	public Long saveGoods(Goods goods){
		goods.setActiveFlag(1);
		goods.setCreateBy("admin");
		goods.setCreateDate(new Date());
		return goodsDao.save(goods);
	}
	@Override
	public List<Goods> find() {
		return goodsDao.find();
	}
	@Override
	public List<Goods> findByPage(Integer pageNo, Goods searchGoods) {
		// limit查询数据开始的下标
				Integer firstResult = (pageNo - 1) * 3;
				// limit查询数据 要显示的条数
				Integer maxResults = 3;
				return goodsDao.findByPage(searchGoods, firstResult, maxResults);
		// limit查询数据开始的下标
			
	}
	@Override
	public Goods findGoodsById(Long rowId) {
		return goodsDao.get(rowId);
	}
	@Override
	public Long doUpdate(Goods goods) {
		// TODO Auto-generated method stub
		goods.setUpdateBy("admin");
		goods.setUpdateDate(new Date());
		goodsDao.update(goods);
		return goods.getRowId();
	}
	@Override
	public Long doDeleteGoods(Long rowId) {
		// TODO Auto-generated method stub
		goodsDao.delete(rowId);
		return rowId;
	}
	@Override
	public Boolean checkGoodsName(String goodsName) {
		// TODO Auto-generated method stub
		Goods goods = goodsDao.getByName(goodsName);
		Boolean bool = goods != null ? false : true;
		return bool;
	}
	@Override
	public PageData buildPageData(Integer pageNo, Goods searchGoods) {
		// 查询出数据总数
				Integer dataCount = goodsDao.getCount(searchGoods);
				return PageUtils.buildPageData(dataCount, pageNo);
	}
}
