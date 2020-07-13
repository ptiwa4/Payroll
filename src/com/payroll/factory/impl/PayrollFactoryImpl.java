package com.payroll.factory.impl;

import com.payroll.domain.PaymentClassification;
import com.payroll.domain.PaymentMethod;
import com.payroll.domain.PaymentSchedule;
import com.payroll.factory.PayrollFactory;

public class PayrollFactoryImpl extends PayrollFactory {

	@Override
	public PaymentClassification makeHourlyClassification(double hourlyRate) {
		return new HourlyClassification(hourlyRate);
	}

	@Override
	public PaymentSchedule makeWeeklySchedule() {
		return new WeeklySchedule();
	}

	@Override
	public PaymentMethod makeHoldMethod() {
		return new HoldMethod();
	}

	@Override
	public PaymentClassification makeSalariedClassification(double salary) {
		return new SalariedClassification(salary);
	}

	@Override
	public PaymentSchedule makeMonthlySchedule() {
		return new MonthlySchedule();
	}

	@Override
	public PayrollFactory setPayrollFactory() {
		return this;
	}

	@Override
	public PaymentSchedule makeBiWeeklySchedule() {
		return new BiweeklySchedule();
	}

	@Override
	public PaymentClassification makeCommissionedClassification(double salary, double commissionRate) {
		return new CommissionedClassification(salary, commissionRate);
	}

}
