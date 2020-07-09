package com.payroll.transaction;

import com.payroll.database.PayrollDatabase;
import com.payroll.domain.Employee;
import com.payroll.domain.PaymentClassification;
import com.payroll.domain.TimeCard;
import com.payroll.factory.impl.HourlyClassification;
import com.payroll.transaction.application.Transaction;

public class TimeCardTransaction implements Transaction {
	String date;
	int hours;
	int empId;	

	public TimeCardTransaction(String date, int hours, int empId) {
		super();
		this.date = date;
		this.hours = hours;
		this.empId = empId;
	}



	@Override
	public void execute() {
		Employee emp = PayrollDatabase.getEmployee(empId);
		PaymentClassification pc = emp.getClassification();
		if(pc instanceof HourlyClassification) {
			HourlyClassification hc = (HourlyClassification) pc;
			hc.setTimeCard(new TimeCard(date, hours));
		}

	}

}
