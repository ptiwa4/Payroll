package com.payroll.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.payroll.application.PayrollApplication;
import com.payroll.application.TextParserTransactionSource;
import com.payroll.application.TransactionSource;
import com.payroll.database.PayrollDatabase;
import com.payroll.domain.Employee;
import com.payroll.domain.PaymentClassification;
import com.payroll.domain.PaymentMethod;
import com.payroll.domain.PaymentSchedule;
import com.payroll.domain.SalesReceipt;
import com.payroll.domain.TimeCard;
import com.payroll.factory.impl.BiweeklySchedule;
import com.payroll.factory.impl.CommissionedClassification;
import com.payroll.factory.impl.HoldMethod;
import com.payroll.factory.impl.HourlyClassification;
import com.payroll.factory.impl.MonthlySchedule;
import com.payroll.factory.impl.PayrollFactoryImpl;
import com.payroll.factory.impl.SalariedClassification;
import com.payroll.factory.impl.WeeklySchedule;
import com.payroll.transaction.impl.TransactionFactoryImpl;

public class PayrollTest {
	PayrollApplication application;

	public PayrollTest() {
		application = new PayrollApplication();
		application.setTransactionFactory(new TransactionFactoryImpl());
		application.setPayrollFactory(new PayrollFactoryImpl());
		application.setTransactionSource(new TextParserTransactionSource());
	}

	@Test
	public void testAddSalariedEmployee() {
		int empId = 1;

		application.getTransactionSource().setTransaction(
				application.getTransactionFactory().makeAddSalaryTransaction(empId, "Prashant", "home", 1000.00));

		application.getTransactionSource().getTransaction().execute();

		// application.getTransactionFactory().makeAddSalaryTransaction(empId,
		// "Prashant", "home", 1000.00).execute();

		Employee emp = PayrollDatabase.getEmployee(empId);
		assertEquals("Prashant", emp.getName());

		PaymentClassification pc = emp.getClassification();
		SalariedClassification sc = (SalariedClassification) pc;
		assertNotNull(sc);
		assertEquals(1000.00, sc.getSalary(), 0.10);

		PaymentSchedule ps = emp.getSchedule();
		MonthlySchedule ms = (MonthlySchedule) ps;
		assertNotNull(ms);

		PaymentMethod pm = emp.getMethod();
		HoldMethod hm = (HoldMethod) pm;
		assertNotNull(hm);

	}

	@Test
	public void testAddHourlyEmployee() {
		int empId = 1;

		application.getTransactionFactory().makeAddHourlyTransaction(empId, "Prashant", "home", 40.00).execute();

		Employee emp = PayrollDatabase.getEmployee(empId);
		assertEquals("Prashant", emp.getName());

		PaymentClassification pc = emp.getClassification();
		HourlyClassification hc = (HourlyClassification) pc;
		assertNotNull(hc);
		assertEquals(40.00, hc.getHourlyRate(), 0.10);

		PaymentSchedule ps = emp.getSchedule();
		WeeklySchedule ws = (WeeklySchedule) ps;
		assertNotNull(ws);

		PaymentMethod pm = emp.getMethod();
		HoldMethod hm = (HoldMethod) pm;
		assertNotNull(hm);

	}

	@Test
	public void testAddCommissionedEmployee() {
		int empId = 5;

		application.getTransactionFactory().makeAddCommissionedTransaction(empId, "Prashant", "home", 40.00, 10)
				.execute();

		Employee emp = PayrollDatabase.getEmployee(empId);
		assertEquals("Prashant", emp.getName());

		PaymentClassification pc = emp.getClassification();
		CommissionedClassification cc = (CommissionedClassification) pc;
		assertNotNull(cc);
		assertEquals(10.00, cc.getCommissionRate(), 0.10);

		PaymentSchedule ps = emp.getSchedule();
		BiweeklySchedule ws = (BiweeklySchedule) ps;
		assertNotNull(ws);

		PaymentMethod pm = emp.getMethod();
		HoldMethod hm = (HoldMethod) pm;
		assertNotNull(hm);
	}

	@Test
	public void testDeleteEmployee() {
		int empId = 2;

		application.getTransactionFactory().makeAddHourlyTransaction(empId, "Ron", "home", 40.00).execute();

		Employee emp = PayrollDatabase.getEmployee(empId);
		assertEquals(2, emp.getId());

		application.getTransactionFactory().makeDeleteEmployeeTransaction(empId).execute();

		emp = PayrollDatabase.getEmployee(empId);
		assertNull(emp);

	}

	@Test
	public void testTimeCardTransaction() {
		int empId = 3;

		application.getTransactionFactory().makeAddHourlyTransaction(empId, "Ron", "home", 40.00).execute();

		application.getTransactionFactory().makeTimeCardTransaction("772020", 8, empId).execute();

		Employee emp = PayrollDatabase.getEmployee(empId);
		assertEquals(3, emp.getId());

		PaymentClassification pc = emp.getClassification();
		HourlyClassification hc = (HourlyClassification) pc;
		assertNotNull(hc);

		TimeCard tc = hc.getTimeCard();
		assertNotNull(tc);
		assertEquals(8, tc.getHours());
	}

	@Test
	public void testAddSalesReceiptTransaction() {
		int empId = 4;

		application.getTransactionFactory().makeAddCommissionedTransaction(empId, "Ron", "home", 40.00, 10).execute();

		application.getTransactionFactory().makeAddSalesReceiptTransaction("772020", 80, empId).execute();

		Employee emp = PayrollDatabase.getEmployee(empId);
		assertEquals(4, emp.getId());

		PaymentClassification pc = emp.getClassification();
		CommissionedClassification cc = (CommissionedClassification) pc;
		assertNotNull(cc);

		SalesReceipt sr = cc.getSalesReceipt();
		assertNotNull(sr);
		assertEquals(80.00, sr.getAmount(), .010);
	}

	// TODO
	@Test
	public void testAddServiceCharge() {

	}

	// TODO
	@Test
	public void testChangeNameTransaction() {

	}

	// TODO
	@Test
	public void testChangeAddressTransaction() {

	}

	// TODO
	@Test
	public void testChangeHourlyTransaction() {

	}

	// TODO
	@Test
	public void testChangeSalariedTransaction() {

	}

	// TODO
	@Test
	public void testChangeCommissionedTransaction() {

	}
}
