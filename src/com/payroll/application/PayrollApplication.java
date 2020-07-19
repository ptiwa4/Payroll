package com.payroll.application;

import static org.junit.Assert.assertEquals;

import com.payroll.database.DatabaseFactoryImpl;
import com.payroll.domain.Employee;
import com.payroll.factory.impl.PayrollFactoryImpl;
import com.payroll.transaction.impl.TransactionFactoryImpl;

public class PayrollApplication extends Application {

	public static void main(String[] args) {
		Application application = new PayrollApplication();
		application.setTransactionFactory(new TransactionFactoryImpl());
		application.setPayrollFactory(new PayrollFactoryImpl());
		application.setTransactionSource(new TextParserTransactionSource());
		application.setDatabaseFactory(new DatabaseFactoryImpl());

		application.getTransactionSource().setTransaction(
				application.getTransactionFactory().makeAddSalaryTransaction(1, "Prashant", "home", 1000.00));

		application.getTransactionSource().getTransaction().execute();

		Employee emp = application.getDatabaseFactory().getDatabase().getEmployee(1);
		assertEquals("Prashant", emp.getName());
	}

}
