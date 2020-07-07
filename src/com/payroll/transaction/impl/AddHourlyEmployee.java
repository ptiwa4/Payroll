package com.payroll.transaction.impl;

import com.payroll.classification.HourlyClassification;
import com.payroll.classification.PaymentClassification;
import com.payroll.method.HoldMethod;
import com.payroll.method.PaymentMethod;
import com.payroll.schedule.PaymentSchedule;
import com.payroll.schedule.WeeklySchedule;
import com.payroll.transaction.AddEmployeeTransaction;

public class AddHourlyEmployee extends AddEmployeeTransaction {
	private double hourlyRate;

	public AddHourlyEmployee(int id, String name, String address, double hourlyRate) {
		super(id, name, address);
		this.hourlyRate = hourlyRate;
	}

	@Override
	protected PaymentClassification getClassification() {		
		return new HourlyClassification(this.hourlyRate);
	}

	@Override
	protected PaymentSchedule getSchedule() {
		return new WeeklySchedule();
	}

	@Override
	protected PaymentMethod getMethod() {
		return new HoldMethod();
	}

}
