package com.xmn.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xmn.bean.BaseDict;
import com.xmn.bean.Items;
import com.xmn.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class ItemController1  {
	@Autowired
	private BaseDictService baseDictService;
	@RequestMapping("/itemList")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response,ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
//		List<Items> itemsList = new ArrayList<Items>();
//
//		Items items_1 = new Items();
//		items_1.setName("联想笔记本");
//		items_1.setPrice(6000f);
//		items_1.setCreatetime(new Date());
//		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
//
//		Items items_2 = new Items();
//		items_2.setName("苹果手机");
//		items_2.setPrice(5000f);
//		items_2.setDetail("iphone6苹果手机！");
//
//		itemsList.add(items_1);
//		itemsList.add(items_2);
//
//		//request.setAttribute("itemsList",itemsList);
//
//		ModelAndView modelAndView=new ModelAndView();
//		modelAndView.addObject("itemsList",itemsList);
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
		modelAndView.addObject("industryType",industryType);

		modelAndView.setViewName("customer");
		
		return modelAndView;
	}
	
}
