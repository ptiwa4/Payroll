package com.payroll.factory.impl;

import com.payroll.domain.PaymentClassification;
import com.payroll.domain.TimeCard;

public class HourlyClassification implements PaymentClassification {

	double hourlyRate;
	TimeCard timeCard;
	
	public HourlyClassification(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public TimeCard getTimeCard() {
		return timeCard;
	}

	public void setTimeCard(TimeCard timeCard) {
		this.timeCard = timeCard;
	}
	
	
	
	

}
