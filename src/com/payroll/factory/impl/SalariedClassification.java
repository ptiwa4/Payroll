package com.payroll.factory.impl;

import com.payroll.domain.PaymentClassification;

public class SalariedClassification implements PaymentClassification {
	private double salary;

	public SalariedClassification(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	

}
