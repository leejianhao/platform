package com.greencloud.website.dto;

import java.util.List;

public class Hr {
	private Long hotelId;
	private List<Room> roomList;	
	private String minRate;	
	private List<Code> rateCodes;
	private List<Code> rmtypes;
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public List<Room> getRoomList() {
		return roomList;
	}
	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}
	public String getMinRate() {
		return minRate;
	}
	public void setMinRate(String minRate) {
		this.minRate = minRate;
	}
	public List<Code> getRateCodes() {
		return rateCodes;
	}
	public void setRateCodes(List<Code> rateCodes) {
		this.rateCodes = rateCodes;
	}
	public List<Code> getRmtypes() {
		return rmtypes;
	}
	public void setRmtypes(List<Code> rmtypes) {
		this.rmtypes = rmtypes;
	}
	
}
