package com.payroll.transaction.factory;

import com.payroll.transaction.application.Transaction;

public abstract class TransactionFactory {

	public abstract Transaction makeAddSalaryTransaction(int id, String name, String address, double salary);

	public abstract Transaction makeAddHourlyTransaction(int id, String name, String address, double hourlyRate);

	public abstract Transaction makeDeleteEmployeeTransaction(int empId);

	public abstract Transaction makeTimeCardTransaction(String date, int hours, int empId);

	public abstract Transaction makeAddCommissionedTransaction(int empId, String name, String address, double salary,
			double commissionRate);

	public abstract Transaction makeAddSalesReceiptTransaction(String date, double amount, int empId);

	public abstract Transaction makeServiceChargeTransaction(int memberId, String date, double charge);

}
