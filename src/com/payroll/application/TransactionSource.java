package com.payroll.application;

import com.payroll.transaction.application.Transaction;

public interface TransactionSource {

	public Transaction getTransaction();
	public void setTransaction(Transaction transaction);
}
