package com.greencloud.website.model;

public class Student {
	private int id;
	private String name;
	
	@FilterField(cid="sex", id="xbdm_equal")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@FilterField(cid="nation", id="mz")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Student() {
		
	}
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
