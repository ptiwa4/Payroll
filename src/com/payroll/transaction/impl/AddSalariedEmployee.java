package com.payroll.transaction.impl;

import com.payroll.classification.PaymentClassification;
import com.payroll.classification.SalariedClassification;
import com.payroll.method.HoldMethod;
import com.payroll.method.PaymentMethod;
import com.payroll.schedule.MonthlySchedule;
import com.payroll.schedule.PaymentSchedule;
import com.payroll.transaction.AddEmployeeTransaction;


public class AddSalariedEmployee extends AddEmployeeTransaction {
	private double salary;
	
	public AddSalariedEmployee(int id, String name, String address, double salary) {
		super(id, name, address);
		this.salary = salary;		
	}	

	@Override
	protected PaymentClassification getClassification() {
		return new SalariedClassification(this.salary);
	}

	@Override
	protected PaymentSchedule getSchedule() {
		return new MonthlySchedule();
	}

	@Override
	protected PaymentMethod getMethod() {
		return new HoldMethod();
	}	
}
