package com.situ.eoa.goods.domain;

import java.io.Serializable;

import com.situ.eoa.base.domain.BaseClass;


public class Goods extends BaseClass implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long catelogueId;
	private String goodsName;
	private Integer goodsNum;
	private String goodsPhoto;
	private double goodsPrice;
	private Integer goodsCount;
	private boolean goodsPutaway;
	private String goodsInfo;
	
	public Long getCatelogueId() {
		return catelogueId;
	}
	public void setCatelogueId(Long catelogueId) {
		this.catelogueId = catelogueId;
	}
	public boolean isGoodsPutaway() {
		return goodsPutaway;
	}
	public void setGoodsPutaway(boolean goodsPutaway) {
		this.goodsPutaway = goodsPutaway;
	}
	public Long getcatelogueId() {
		return catelogueId;
	}
	public void setcatelogueId(Long catelogueId) {
		this.catelogueId = catelogueId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoodsPhoto() {
		return goodsPhoto;
	}
	public void setGoodsPhoto(String goodsPhoto) {
		this.goodsPhoto = goodsPhoto;
	}
	public double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Integer getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}
	public boolean isgoodsPutaway() {
		return goodsPutaway;
	}
	public void setgoodsPutaway(boolean goodsPutaway) {
		this.goodsPutaway = goodsPutaway;
	}
	public String getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	
}
