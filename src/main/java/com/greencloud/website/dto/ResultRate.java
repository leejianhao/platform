package com.greencloud.website.dto;

import java.util.List;

public class ResultRate extends ResultBase{
	private List<Hr> hrList;

	private Integer totalRows;
	
	public List<Hr> getHrList() {
		return hrList;
	}

	public void setHrList(List<Hr> hrList) {
		this.hrList = hrList;
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}
}
