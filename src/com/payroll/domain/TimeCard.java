package com.payroll.domain;

public class TimeCard {

	String date;
	int hours;
	
	public TimeCard(String date, int hours) {
		super();
		this.date = date;
		this.hours = hours;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
	
	
	

}
