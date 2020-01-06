package com.situ.eoa.goods.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.eoa.goods.domain.Goods;
@Repository
public interface GoodsDao extends Serializable {
	Long save(Goods goods);
	void update(Goods goods);
	void delete(Long goodsId);
	Goods get(Long GoodsId);
	List<Goods> find();
	List<Goods> findByPage(@Param("searchGoods")Goods searchGoods,@Param("firstResult") Integer firstResult, @Param("maxResults") Integer maxResults);
	Goods getByName(String goodsName);
	Integer getCount(@Param("searchGoods")Goods searchGoods);
}
