package com.payroll.transaction.impl;

import com.payroll.domain.PaymentClassification;
import com.payroll.domain.PaymentMethod;
import com.payroll.domain.PaymentSchedule;
import com.payroll.factory.PayrollFactory;
import com.payroll.transaction.AddEmployeeTransaction;

public class AddHourlyEmployee extends AddEmployeeTransaction {
	private double hourlyRate;

	public AddHourlyEmployee(int id, String name, String address, double hourlyRate) {
		super(id, name, address);
		this.hourlyRate = hourlyRate;
	}

	@Override
	protected PaymentClassification getClassification() {		
		return PayrollFactory.INSTANCE.makeHourlyClassification(this.hourlyRate);
	}

	@Override
	protected PaymentSchedule getSchedule() {
		return PayrollFactory.INSTANCE.makeWeeklySchedule();
	}

	@Override
	protected PaymentMethod getMethod() {
		return PayrollFactory.INSTANCE.makeHoldMethod();
	}

}
