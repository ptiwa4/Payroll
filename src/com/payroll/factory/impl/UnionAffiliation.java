package com.payroll.factory.impl;

import com.payroll.domain.Affiliation;
import com.payroll.domain.ServiceCharge;

public class UnionAffiliation implements Affiliation {

	private double amount;
	private ServiceCharge serviceCharge;

	public UnionAffiliation(double amount) {
		super();
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public ServiceCharge getServiceCharge(String date) {
		return serviceCharge;
	}

	public void setServiceCharge(ServiceCharge serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

}