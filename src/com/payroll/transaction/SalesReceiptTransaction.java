package com.payroll.transaction;

import com.payroll.database.DatabaseFactory;
import com.payroll.domain.Employee;
import com.payroll.domain.PaymentClassification;
import com.payroll.domain.SalesReceipt;
import com.payroll.factory.impl.CommissionedClassification;
import com.payroll.transaction.application.Transaction;

public class SalesReceiptTransaction implements Transaction {

	private String date;
	private double amount;
	private int empId;

	public SalesReceiptTransaction(String date, double amount, int empId) {
		super();
		this.date = date;
		this.amount = amount;
		this.empId = empId;
	}

	@Override
	public void execute() {
		Employee emp = DatabaseFactory.DB_FACTORY_INSTANCE.getDatabase().getEmployee(empId);
		PaymentClassification pc = emp.getClassification();
		if (pc instanceof CommissionedClassification) {
			CommissionedClassification cc = (CommissionedClassification) pc;
			cc.setSalesReceipt(new SalesReceipt(amount, date));
		}

	}

}
