package com.payroll.transaction.impl;

import com.payroll.domain.PaymentClassification;
import com.payroll.domain.PaymentMethod;
import com.payroll.domain.PaymentSchedule;
import com.payroll.factory.PayrollFactory;
import com.payroll.transaction.AddEmployeeTransaction;


public class AddSalariedEmployee extends AddEmployeeTransaction {
	private double salary;
	
	public AddSalariedEmployee(int id, String name, String address, double salary) {
		super(id, name, address);
		this.salary = salary;		
	}	

	@Override
	protected PaymentClassification getClassification() {
		return PayrollFactory.INSTANCE.makeSalariedClassification(this.salary);
	}

	@Override
	protected PaymentSchedule getSchedule() {
		return PayrollFactory.INSTANCE.makeMonthlySchedule();
	}

	@Override
	protected PaymentMethod getMethod() {
		return PayrollFactory.INSTANCE.makeHoldMethod();
	}	
}
