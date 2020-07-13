package com.payroll.factory.impl;

import com.payroll.domain.PaymentClassification;
import com.payroll.domain.SalesReceipt;

public class CommissionedClassification implements PaymentClassification {
	private double salary;
	private double commissionRate;
	private SalesReceipt salesReceipt;

	public CommissionedClassification(double salary, double commissionRate) {
		this.salary = salary;
		this.commissionRate = commissionRate;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public SalesReceipt getSalesReceipt() {
		return salesReceipt;
	}

	public void setSalesReceipt(SalesReceipt salesReceipt) {
		this.salesReceipt = salesReceipt;
	}

}
