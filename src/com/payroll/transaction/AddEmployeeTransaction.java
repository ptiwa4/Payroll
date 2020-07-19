package com.payroll.transaction;

import com.payroll.database.DatabaseFactory;
import com.payroll.domain.Employee;
import com.payroll.domain.PaymentClassification;
import com.payroll.domain.PaymentMethod;
import com.payroll.domain.PaymentSchedule;
import com.payroll.transaction.application.Transaction;

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
		DatabaseFactory.DB_FACTORY_INSTANCE.getDatabase().addEmployee(id, e);
	}

	protected abstract PaymentClassification getClassification();

	protected abstract PaymentSchedule getSchedule();

	protected abstract PaymentMethod getMethod();

}
