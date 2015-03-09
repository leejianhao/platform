package com.greencloud.website.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;

import com.greencloud.website.InterfaceMethod;
import com.greencloud.website.SysConstant;
import com.greencloud.website.dto.PmsParamsDto;
import com.greencloud.website.dto.ResultRate;
import com.greencloud.website.service.IBookingService;
import com.greencloud.website.util.DateUtil;
import com.greencloud.website.util.GsonUtil;
import com.greencloud.website.util.HttpUtil;

@Service("bookingService")
public class BookingServiceImpl extends ServiceImpl implements IBookingService{
	
	@Resource(name="httpUtilForCrs")
	private HttpUtil httpUtilForCrs;
	
	@Resource
	private InterfaceMethod interfaceMethod;
	
	/**
	 * 取pms客房数据
	 * @param checkIn     入住日期
	 * @param daycount    入住天数
	 * @param cityCode    城市code
	 * @param hotelIds    酒店id集合
	 * @param order		  ?排序
	 * @param brandCode   品牌code 
	 * @param firstResult 分页，记录开始位置
	 * @param pageSize	       分页，每页记录数
	 * @param rateCodes	       房价码
	 * @param channel	       渠道
	 * @return 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	private ResultRate findRoom(Date checkIn, Integer daycount, String cityCode,
			List<Long> hotelIds, String order, String brandCode,
			Integer firstResult, Integer pageSize, String rateCodes,
			String channel) throws ClientProtocolException, IOException {
		
		httpUtilForCrs.setMethod(interfaceMethod.getRoom());
		
		List<NameValuePair> ps = new ArrayList<NameValuePair>();

		if (checkIn != null) {
			ps.add(new BasicNameValuePair("date", DateUtil.format(checkIn, SysConstant.CHECK_DATE)));
		}
		if (daycount != null) {
			ps.add(new BasicNameValuePair("dayCount", String.valueOf(daycount)));
		}
		
		if (cityCode != null) {
			ps.add(new BasicNameValuePair("cityCode", cityCode));
		}
		if (brandCode != null) {
			ps.add(new BasicNameValuePair("brandCode", brandCode));
		}
		if (order != null) {
			ps.add(new BasicNameValuePair("order", order));
		}
		if (firstResult != null) {
			ps.add(new BasicNameValuePair("firstResult", String.valueOf(firstResult)));
		}
		if (pageSize != null) {
			ps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
		}
		if (rateCodes != null) {
			ps.add(new BasicNameValuePair("rateCodes", String.valueOf(rateCodes)));
		}
		
		ps.add(new BasicNameValuePair("salesChannel", channel));
		
		if(hotelIds!=null){
			StringBuilder sb = new StringBuilder();
			for(Long id : hotelIds){
				sb.append(String.valueOf(id));
				sb.append(",");
			}
			if(sb.length()>0){
				sb.deleteCharAt(sb.length()-1);
				ps.add(new BasicNameValuePair("hotelIds", sb.toString()));
			}
		}
		
		String rateResult = httpUtilForCrs.post(ps);
		System.out.println(rateResult);
		return GsonUtil.getGsonWithDateFormat().fromJson(rateResult, ResultRate.class);
	}

	@Override
	public void pms_findRoom(PmsParamsDto queryParam) throws ClientProtocolException, IOException {
		ResultRate result = findRoom(queryParam.getCheckIn(),queryParam.getDayCount(),queryParam.getCityCode(),queryParam.getHotelIds(),queryParam.getOrder(),queryParam.getBrandCode(),queryParam.getFirstResult(),queryParam.getPageSize(),queryParam.getRateCodes(),queryParam.getChannel());
		
	}

}
