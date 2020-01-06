package com.situ.eoa.goods.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.eoa.goods.domain.Goods;
import com.situ.eoa.goods.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController implements Serializable{
	private static final long serialVersionUID = 1L;
	@Autowired
	private GoodsService goodsService;
	
	
	@ResponseBody
	@RequestMapping("/add")
	public Long doAddGoods(Goods goods) {
		
		return goodsService.saveGoods(goods);
	}
	
	@RequestMapping("/index")
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.setViewName("goods/goods_index");
		return modelAndView;
	}
	
	@RequestMapping("/find/{pageNo}")
	public ModelAndView findAllGoods(@PathVariable Integer pageNo, Goods searchGoods, ModelAndView modelAndView) {
		System.out.println(searchGoods);
		// 要展示的列表数据
		modelAndView.addObject("goodsList", goodsService.findByPage(pageNo,searchGoods));
		// 分页信息
		modelAndView.addObject("pageData", goodsService.buildPageData(pageNo,searchGoods));
		modelAndView.setViewName("goods/goods_list");
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping("/goUpdate/{rowId}") 
	public Goods goUpdate (@PathVariable("rowId") Long rowId) {
		return goodsService.findGoodsById(rowId);
		
	}
	
	@ResponseBody
	@RequestMapping("doUpdate")
	public Long doUpdateGoods(Goods goods) {
		return this.doUpdateGoods(goods);
		
	}
	@ResponseBody
	@RequestMapping("/doDelete/{rowId}")
	public Long doDelete(@PathVariable Long rowId) {
		return this.goodsService.doDeleteGoods(rowId);
		
	}
	

}
