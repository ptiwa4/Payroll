package com.payroll.factory;

import com.payroll.domain.PaymentClassification;
import com.payroll.domain.PaymentMethod;
import com.payroll.domain.PaymentSchedule;

public interface PayrollFactory {

	PaymentClassification makeHourlyClassification(double hourlyRate);
	PaymentSchedule makeWeeklySchedule();
	PaymentMethod makeHoldMethod();
	PaymentClassification makeSalariedClassification(double salary);
	PaymentSchedule makeMonthlySchedule();
}
