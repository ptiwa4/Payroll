package com.payroll.transaction.impl;

import com.payroll.domain.PaymentClassification;
import com.payroll.domain.PaymentMethod;
import com.payroll.domain.PaymentSchedule;
import com.payroll.transaction.AddEmployeeTransaction;

public class AddCommissionedEmployee extends AddEmployeeTransaction {
	private double salary;
	private double commissionRate;

	public AddCommissionedEmployee(int id, String name, String address, double salary, double commissionRate) {
		super(id, name, address);
		this.salary = salary;
		this.commissionRate = commissionRate;
	}

	@Override
	protected PaymentClassification getClassification() {
		return this.payrollFactory.makeCommissionedClassification(this.salary, this.commissionRate);
	}

	@Override
	protected PaymentSchedule getSchedule() {
		return this.payrollFactory.makeBiWeeklySchedule();
	}

	@Override
	protected PaymentMethod getMethod() {
		return this.payrollFactory.makeHoldMethod();
	}	

}
