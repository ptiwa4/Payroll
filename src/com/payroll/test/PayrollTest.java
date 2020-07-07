package com.payroll.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.payroll.classification.HourlyClassification;
import com.payroll.classification.PaymentClassification;
import com.payroll.classification.SalariedClassification;
import com.payroll.database.PayrollDatabase;
import com.payroll.method.HoldMethod;
import com.payroll.method.PaymentMethod;
import com.payroll.model.Employee;
import com.payroll.model.TimeCard;
import com.payroll.schedule.MonthlySchedule;
import com.payroll.schedule.PaymentSchedule;
import com.payroll.schedule.WeeklySchedule;
import com.payroll.transaction.DeleteEmployeeTransaction;
import com.payroll.transaction.TimeCardTransaction;
import com.payroll.transaction.Transaction;
import com.payroll.transaction.impl.AddHourlyEmployee;
import com.payroll.transaction.impl.AddSalariedEmployee;

public class PayrollTest {

	@Test
	public void testAddSalariedEmployee() {
		int empId = 1;
		Transaction transaction = new AddSalariedEmployee(empId, "Prashant", "home", 1000.00);
		transaction.execute();

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
		Transaction transaction = new AddHourlyEmployee(empId, "Prashant", "home", 40.00);
		transaction.execute();

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

		Transaction transaction = new AddHourlyEmployee(empId, "Ron", "home", 40.00);
		transaction.execute();

		Employee emp = PayrollDatabase.getEmployee(empId);
		assertEquals(2, emp.getId());

		transaction = new DeleteEmployeeTransaction(empId);
		transaction.execute();

		emp = PayrollDatabase.getEmployee(empId);
		assertNull(emp);

	}

	@Test
	public void testTimeCardTransaction() {
		int empId = 3;

		Transaction transaction = new AddHourlyEmployee(empId, "Ron", "home", 40.00);
		transaction.execute();		
		
		transaction = new TimeCardTransaction("772020", 8, empId);
		transaction.execute();
		
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
	public void testAddServiceCharge() {
		int empId = 4;

		Transaction transaction = new AddHourlyEmployee(empId, "Ron", "home", 40.00);
		transaction.execute();		
		
		Employee emp = PayrollDatabase.getEmployee(empId);
		assertEquals(4, emp.getId());
		
		UnionAffiliation uf = new UnionAffiliation(12.5);
		emp.setAffiliation(uf);
		
		int memberId = 86;
		PayrollDatabase.addUnionMember(memberId, emp);
		
		transaction = new ServiceChargeTransaction(memberId, "772020", 12.95);
		transaction.execute();
		
		ServiceCharge sc = uf.getServiceCharge();
		assert(sc);
		assertEquals(12.95, sc.getAmount(), .001);		
	}
}
