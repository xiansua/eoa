package com.situ.eoa.list1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {
	@ResponseBody
	@RequestMapping("/catalogue")
	public ModelAndView goCatalogue(ModelAndView modelAndView) {
		modelAndView.setViewName("goods/Catalogue");
		return modelAndView;
	}
}
