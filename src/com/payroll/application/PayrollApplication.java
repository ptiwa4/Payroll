package com.payroll.application;

import com.payroll.factory.PayrollFactory;
import com.payroll.factory.impl.PayrollFactoryImpl;
import com.payroll.transaction.factory.TransactionFactory;
import com.payroll.transaction.impl.TransactionFactoryImpl;

public class PayrollApplication implements Application{
	
	TransactionSource transactionSource;
	TransactionFactory transactionFactory;
	PayrollFactory payrollFactory;

	
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

	public static void main(String[] args) {
		PayrollApplication application = new PayrollApplication();
		application.setTransactionFactory(new TransactionFactoryImpl());
		application.setPayrollFactory(new PayrollFactoryImpl());
		application.setTransactionSource(new TextParserTransactionSource());
		
		application.getTransactionSource().getTransaction().execute();
	}

}
