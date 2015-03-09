package com.greencloud.website.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.greencloud.website.dto.PmsParamsDto;
import com.greencloud.website.service.IBookingService;

@Controller
@RequestMapping("/book")
public class BookingController {
	
	private @Resource IBookingService bookingService;
	/**
	 * 展现形式 - 列表
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	@RequestMapping(value="/hotelList", params="queryType=list", method=RequestMethod.GET)
	public String hotelList_list(
			@RequestParam(required=false) String checkInDate,
			@RequestParam(required=false) String checkOutDate,
			@RequestParam(required=false) String cityCode,
			@RequestParam(required=false) String brandCode)
					throws ClientProtocolException, IOException {
		
		@SuppressWarnings("serial")
		List<Long> hotelIds = new ArrayList<Long>() {
			{
				this.add(1l);
			}
		};
		PmsParamsDto queryParam = new PmsParamsDto();
		queryParam.setCheckIn(new Date());
		queryParam.setCityCode("BJBJ");
		queryParam.setDayCount(1);
		queryParam.setHotelIds(hotelIds);
		queryParam.setRateCodes("");
		queryParam.setChannel("WEB");
		bookingService.pms_findRoom(queryParam);
		return "list";
	}
}
