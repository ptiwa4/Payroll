package com.payroll.application;

import com.payroll.transaction.application.Transaction;

public class TextParserTransactionSource implements TransactionSource {
	private Transaction transaction;

	@Override
	public Transaction getTransaction() {
		return transaction;
	}

	@Override
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;		
	}

}
