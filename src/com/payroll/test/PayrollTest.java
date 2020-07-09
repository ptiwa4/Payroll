package com.payroll.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.payroll.database.PayrollDatabase;
import com.payroll.domain.Employee;
import com.payroll.domain.PaymentClassification;
import com.payroll.domain.PaymentMethod;
import com.payroll.domain.PaymentSchedule;
import com.payroll.domain.TimeCard;
import com.payroll.factory.impl.HoldMethod;
import com.payroll.factory.impl.HourlyClassification;
import com.payroll.factory.impl.MonthlySchedule;
import com.payroll.factory.impl.SalariedClassification;
import com.payroll.factory.impl.WeeklySchedule;
import com.payroll.transaction.factory.TransactionFactory;
import com.payroll.transaction.impl.TransactionFactoryImpl;

public class PayrollTest {
	TransactionFactory factory;

	public PayrollTest() {
		factory = new TransactionFactoryImpl();
	}

	@Test
	public void testAddSalariedEmployee() {
		int empId = 1;

		factory.makeAddSalaryTransaction(empId, "Prashant", "home", 1000.00).execute();

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

		factory.makeAddHourlyTransaction(empId, "Prashant", "home", 40.00).execute();

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
	public void testDeleteEmployee() {
		int empId = 2;

		factory.makeAddHourlyTransaction(empId, "Ron", "home", 40.00).execute();

		Employee emp = PayrollDatabase.getEmployee(empId);
		assertEquals(2, emp.getId());

		factory.makeDeleteEmployeeTransaction(empId).execute();

		emp = PayrollDatabase.getEmployee(empId);
		assertNull(emp);

	}

	@Test
	public void testTimeCardTransaction() {
		int empId = 3;

		factory.makeAddHourlyTransaction(empId, "Ron", "home", 40.00).execute();

		factory.makeTimeCardTransaction("772020", 8, empId).execute();

		Employee emp = PayrollDatabase.getEmployee(empId);
		assertEquals(3, emp.getId());

		PaymentClassification pc = emp.getClassification();
		HourlyClassification hc = (HourlyClassification) pc;
		assertNotNull(hc);

		TimeCard tc = hc.getTimeCard();
		assertNotNull(tc);
		assertEquals(8, tc.getHours());
	}

	// TODO
	@Test
	public void testAddSalesReceiptTransaction() {

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
