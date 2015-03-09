package com.greencloud.website.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.greencloud.website.dto.PmsParamsDto;

public interface IBookingService extends IService{
	
	/**
	 * 取客房数据
	 * @param dto
	 */
	public void pms_findRoom(PmsParamsDto queryParam) throws ClientProtocolException, IOException;	
}
