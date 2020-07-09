package com.payroll.transaction.factory;

import com.payroll.transaction.application.Transaction;

public interface TransactionFactory {

	public Transaction makeAddSalaryTransaction(int id, String name, String address, double salary);
	public Transaction makeAddHourlyTransaction(int id, String name, String address, double hourlyRate);
	public Transaction makeDeleteEmployeeTransaction(int empId);
	public Transaction makeTimeCardTransaction(String date, int hours, int empId);
	
}
