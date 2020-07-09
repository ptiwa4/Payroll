package com.payroll.factory.impl;

import com.payroll.domain.PaymentClassification;
import com.payroll.domain.PaymentMethod;
import com.payroll.domain.PaymentSchedule;
import com.payroll.factory.PayrollFactory;

public class PayrollFactoryImpl implements PayrollFactory {

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

}
