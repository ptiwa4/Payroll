package com.payroll.model;

import com.payroll.classification.PaymentClassification;
import com.payroll.method.PaymentMethod;
import com.payroll.schedule.PaymentSchedule;

public class Employee {
	private int id;
	private String name;
	private String address;
	private PaymentClassification classification;
	private PaymentSchedule schedule;
	private PaymentMethod method;

	public Employee(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public void setClassification(PaymentClassification classification) {
		this.classification = classification;
	}

	public void setSchedule(PaymentSchedule schedule) {
		this.schedule = schedule;
	}

	public void setMethod(PaymentMethod method) {
		this.method = method;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public PaymentClassification getClassification() {
		return classification;
	}

	public PaymentSchedule getSchedule() {
		return schedule;
	}

	public PaymentMethod getMethod() {
		return method;
	}
	
	
	
	
}
