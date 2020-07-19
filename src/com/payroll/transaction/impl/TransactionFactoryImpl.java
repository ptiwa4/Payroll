package com.payroll.transaction.impl;

import com.payroll.transaction.DeleteEmployeeTransaction;
import com.payroll.transaction.SalesReceiptTransaction;
import com.payroll.transaction.ServiceChargeTransaction;
import com.payroll.transaction.TimeCardTransaction;
import com.payroll.transaction.application.Transaction;
import com.payroll.transaction.factory.TransactionFactory;

public class TransactionFactoryImpl extends TransactionFactory {

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

	@Override
	public Transaction makeAddCommissionedTransaction(int empId, String name, String address, double salary,
			double commissionRate) {
		return new AddCommissionedEmployee(empId, name, address, salary, commissionRate);
	}

	@Override
	public Transaction makeAddSalesReceiptTransaction(String date, double amount, int empId) {
		return new SalesReceiptTransaction(date, amount, empId);
	}

	@Override
	public Transaction makeServiceChargeTransaction(int memberId, String date, double charge) {
		return new ServiceChargeTransaction(memberId, date, charge);
	}

}
