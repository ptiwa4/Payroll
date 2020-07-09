package com.payroll.transaction.impl;

import com.payroll.transaction.DeleteEmployeeTransaction;
import com.payroll.transaction.TimeCardTransaction;
import com.payroll.transaction.application.Transaction;
import com.payroll.transaction.factory.TransactionFactory;

public class TransactionFactoryImpl implements TransactionFactory {

	@Override
	public Transaction makeAddSalaryTransaction(int id, String name, String address, double salary) {
		return new AddSalariedEmployee(id, name, address, salary);
	}

	@Override
	public Transaction makeAddHourlyTransaction(int id, String name, String address, double hourlyRate) {
		return  new AddHourlyEmployee(id, name, address, hourlyRate);
	}

	@Override
	public Transaction makeDeleteEmployeeTransaction(int empId) {
		return new DeleteEmployeeTransaction(empId);
	}

	@Override
	public Transaction makeTimeCardTransaction(String date, int hours, int empId) {
		return new TimeCardTransaction(date, hours, empId);
	}

}
