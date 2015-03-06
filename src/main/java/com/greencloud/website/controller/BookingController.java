package com.greencloud.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/book")
public class BookingController {
	
	/**
	 * 展现形式 - 列表
	 * @return
	 */
	@RequestMapping(value="/hotelList", params="queryType=list", method=RequestMethod.GET)
	public String hotelList_list() {
		
		return "list";
	}
}
