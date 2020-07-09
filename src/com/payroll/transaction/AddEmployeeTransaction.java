package com.payroll.transaction;

import com.payroll.database.PayrollDatabase;
import com.payroll.domain.Employee;
import com.payroll.domain.PaymentClassification;
import com.payroll.domain.PaymentMethod;
import com.payroll.domain.PaymentSchedule;
import com.payroll.factory.PayrollFactory;
import com.payroll.factory.impl.PayrollFactoryImpl;
import com.payroll.transaction.application.Transaction;

public abstract class AddEmployeeTransaction implements Transaction {	
	protected int id;
	protected String name;
	protected String address;
	protected PayrollFactory payrollFactory;

	public AddEmployeeTransaction(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.payrollFactory = new PayrollFactoryImpl();
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
