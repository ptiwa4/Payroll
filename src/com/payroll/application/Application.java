package com.payroll.application;

import com.payroll.database.DatabaseFactory;
import com.payroll.factory.PayrollFactory;
import com.payroll.transaction.factory.TransactionFactory;

public abstract class Application {
	
	TransactionSource transactionSource;
	TransactionFactory transactionFactory;
	PayrollFactory payrollFactory;
	DatabaseFactory databaseFactory;

	public TransactionSource getTransactionSource() {
		return transactionSource;
	}

	public void setTransactionSource(TransactionSource transactionSource) {
		this.transactionSource = transactionSource;
	}

	public TransactionFactory getTransactionFactory() {
		return transactionFactory;
	}

	public void setTransactionFactory(TransactionFactory transactionFactory) {
		this.transactionFactory = transactionFactory;
	}

	public PayrollFactory getPayrollFactory() {
		return payrollFactory;
	}

	public void setPayrollFactory(PayrollFactory payrollFactory) {
		this.payrollFactory = payrollFactory;
	}

	public DatabaseFactory getDatabaseFactory() {
		return databaseFactory;
	}

	public void setDatabaseFactory(DatabaseFactory databaseFactory) {
		this.databaseFactory = databaseFactory;
	}
	
	
}
