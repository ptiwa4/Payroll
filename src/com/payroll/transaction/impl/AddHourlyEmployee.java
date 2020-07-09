package com.payroll.transaction.impl;

import com.payroll.domain.PaymentClassification;
import com.payroll.domain.PaymentMethod;
import com.payroll.domain.PaymentSchedule;
import com.payroll.transaction.AddEmployeeTransaction;

public class AddHourlyEmployee extends AddEmployeeTransaction {
	private double hourlyRate;

	public AddHourlyEmployee(int id, String name, String address, double hourlyRate) {
		super(id, name, address);
		this.hourlyRate = hourlyRate;
	}

	@Override
	protected PaymentClassification getClassification() {		
		return this.payrollFactory.makeHourlyClassification(this.hourlyRate);
	}

	@Override
	protected PaymentSchedule getSchedule() {
		return this.payrollFactory.makeWeeklySchedule();
	}

	@Override
	protected PaymentMethod getMethod() {
		return this.payrollFactory.makeHoldMethod();
	}

}
