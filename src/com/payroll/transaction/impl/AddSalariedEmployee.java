package com.payroll.transaction.impl;

import com.payroll.domain.PaymentClassification;
import com.payroll.domain.PaymentMethod;
import com.payroll.domain.PaymentSchedule;
import com.payroll.factory.impl.HoldMethod;
import com.payroll.factory.impl.MonthlySchedule;
import com.payroll.factory.impl.SalariedClassification;
import com.payroll.transaction.AddEmployeeTransaction;


public class AddSalariedEmployee extends AddEmployeeTransaction {
	private double salary;
	
	public AddSalariedEmployee(int id, String name, String address, double salary) {
		super(id, name, address);
		this.salary = salary;		
	}	

	@Override
	protected PaymentClassification getClassification() {
		return this.payrollFactory.makeSalariedClassification(this.salary);
	}

	@Override
	protected PaymentSchedule getSchedule() {
		return this.payrollFactory.makeMonthlySchedule();
	}

	@Override
	protected PaymentMethod getMethod() {
		return this.payrollFactory.makeHoldMethod();
	}	
}
