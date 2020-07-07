package com.payroll.transaction;

import com.payroll.classification.PaymentClassification;
import com.payroll.database.PayrollDatabase;
import com.payroll.method.PaymentMethod;
import com.payroll.model.Employee;
import com.payroll.schedule.PaymentSchedule;

public abstract class AddEmployeeTransaction implements Transaction {	
	protected int id;
	protected String name;
	protected String address;
	

	public AddEmployeeTransaction(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	@Override
	public void execute() {
		Employee e = new Employee(id, name, address);
		e.setClassification(this.getClassification());
		e.setSchedule(this.getSchedule());
		e.setMethod(this.getMethod());
		PayrollDatabase.addEmployee(id, e);

	}
	
	protected abstract PaymentClassification getClassification();
	protected abstract PaymentSchedule getSchedule();
	protected abstract PaymentMethod getMethod();
	
}
