package com.greencloud.website.dto;

import java.util.Date;
import java.util.List;

import com.geencloud.website.annotation.RequestParamRequired;

public class PmsParamsDto {
	
	@RequestParamRequired
	private Date checkIn;
	
	@RequestParamRequired
	private int dayCount;
	
	@RequestParamRequired
	private String cityCode;
	
	@RequestParamRequired
	private List<Long> hotelIds;
	
	private String order;
	
	private String brandCode;
	
	private int firstResult;
	
	private int pageSize;
	
	@RequestParamRequired
	private String rateCodes;
	
	@RequestParamRequired
	private String channel;
	
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public int getDayCount() {
		return dayCount;
	}
	public void setDayCount(int dayCount) {
		this.dayCount = dayCount;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public List<Long> getHotelIds() {
		return hotelIds;
	}
	public void setHotelIds(List<Long> hotelIds) {
		this.hotelIds = hotelIds;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getBrandCode() {
		return brandCode;
	}
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	public int getFirstResult() {
		return firstResult;
	}
	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getRateCodes() {
		return rateCodes;
	}
	public void setRateCodes(String rateCodes) {
		this.rateCodes = rateCodes;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
}
