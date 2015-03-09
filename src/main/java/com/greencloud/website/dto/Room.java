package com.greencloud.website.dto;

import java.math.BigDecimal;

public class Room {
	private String ratecode;
	private String rmtype;
//	private BigDecimal rate1;
//	private BigDecimal avgRate1;
//	private BigDecimal crate1;
	
	private String rate1;
	private String avgRate1;
	private String crate1;
	
	private String src;
	private String market;
	private String packages;
	private Integer advMin;
	private Integer advMax;
	private Integer stayMin;
	private Integer stayMax;
	private Integer avail;
	private String depositRule;
	
	//Website
	private String ratecodeDescript;
	private String rmtypeDescript;
	private String packagesDescript;
	
//	private Integer availIn;
//	private List<RateCode> rateCodes;
//	private String descript;
	
	public String getRatecode() {
		return ratecode;
	}
	public void setRatecode(String ratecode) {
		this.ratecode = ratecode;
	}
	
	public String getRmtype() {
		return rmtype;
	}
	public void setRmtype(String rmtype) {
		this.rmtype = rmtype;
	}
	public String getAvgRate1() {
		return avgRate1;
	}
	public void setAvgRate1(String avgRate1) {
		this.avgRate1 = avgRate1;
	}
	
	public String getCrate1() {
		return crate1;
	}
	public void setCrate1(String crate1) {
		this.crate1 = crate1;
	}
	
	public String getRate1() {
		return rate1;
	}
	public void setRate1(String rate1) {
		this.rate1 = rate1;
	}
	
//	public BigDecimal getAvgRate1() {
//		return avgRate1;
//	}
//	public void setAvgRate1(BigDecimal avgRate1) {
//		this.avgRate1 = avgRate1;
//	}
//	
//	public BigDecimal getCrate1() {
//		return crate1;
//	}
//	public void setCrate1(BigDecimal crate1) {
//		this.crate1 = crate1;
//	}
//	
//	public BigDecimal getRate1() {
//		return rate1;
//	}
//	public void setRate1(BigDecimal rate1) {
//		this.rate1 = rate1;
//	}
	
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	
	public String getPackages() {
		return packages;
	}
	public void setPackages(String packages) {
		this.packages = packages;
	}
	public Integer getAdvMin() {
		return advMin;
	}
	public void setAdvMin(Integer advMin) {
		this.advMin = advMin;
	}
	
	public Integer getAdvMax() {
		return advMax;
	}
	public void setAdvMax(Integer advMax) {
		this.advMax = advMax;
	}
	
	public Integer getStayMin() {
		return stayMin;
	}
	public void setStayMin(Integer stayMin) {
		this.stayMin = stayMin;
	}
	
	public Integer getStayMax() {
		return stayMax;
	}
	public void setStayMax(Integer stayMax) {
		this.stayMax = stayMax;
	}
	
	public Integer getAvail() {
		return avail;
	}
	public void setAvail(Integer avail) {
		this.avail = avail;
	}

	public String getDepositRule() {
		return depositRule;
	}
	public void setDepositRule(String depositRule) {
		this.depositRule = depositRule;
	}
	
	public String getRatecodeDescript() {
		return ratecodeDescript;
	}
	public void setRatecodeDescript(String ratecodeDescript) {
		this.ratecodeDescript = ratecodeDescript;
	}
	
	public String getRmtypeDescript() {
		return rmtypeDescript;
	}
	public void setRmtypeDescript(String rmtypeDescript) {
		this.rmtypeDescript = rmtypeDescript;
	}
	public void setPackagesDescript(String packagesDescript) {
		this.packagesDescript = packagesDescript;
	}
	public String getPackagesDescript() {
		return packagesDescript;
	}

}
