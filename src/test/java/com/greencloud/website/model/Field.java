package com.greencloud.website.model;

public class Field {
	private String cid;
	private String id;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Field(String cid, String id) {
		super();
		this.cid = cid;
		this.id = id;
	}
	public Field() {
	}
	
}
