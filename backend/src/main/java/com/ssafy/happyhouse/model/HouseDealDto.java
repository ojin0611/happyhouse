package com.ssafy.happyhouse.model;

public class HouseDealDto {
	String dong;
	String AptName;
	String dealAmount;
	String buildYear;
	String dealYear;
	String dealMonth;
	public String getDealMonth() {
		return dealMonth;
	}


	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}


	String dealDay;
	String floor;
	String code;
	String area;
	String type;
	
	
	public String getDong() {
		return dong;
	}


	public void setDong(String dong) {
		this.dong = dong;
	}


	public String getAptName() {
		return AptName;
	}


	public void setAptName(String aptName) {
		AptName = aptName;
	}


	public String getDealAmount() {
		return dealAmount;
	}


	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}


	public String getBuildYear() {
		return buildYear;
	}


	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}


	public String getDealYear() {
		return dealYear;
	}


	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}


	public String getDealDay() {
		return dealDay;
	}


	public void setDealDay(String dealDay) {
		this.dealDay = dealDay;
	}


	public String getFloor() {
		return floor;
	}


	public void setFloor(String floor) {
		this.floor = floor;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public HouseDealDto() {
		super();
	}


	public HouseDealDto(String dong, String aptName, String dealAmount, String buildYear, String dealYear,
			String dealDay, String floor, String code, String area, String type) {
		super();
		this.dong = dong;
		AptName = aptName;
		this.dealAmount = dealAmount;
		this.buildYear = buildYear;
		this.dealYear = dealYear;
		this.dealDay = dealDay;
		this.floor = floor;
		this.code = code;
		this.area = area;
		this.type = type;
	}
	
}
