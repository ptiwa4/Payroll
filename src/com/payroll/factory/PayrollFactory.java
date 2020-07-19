package com.payroll.factory;

import com.payroll.domain.PaymentClassification;
import com.payroll.domain.PaymentMethod;
import com.payroll.domain.PaymentSchedule;

public abstract class PayrollFactory {

	public static PayrollFactory INSTANCE;
	public abstract PaymentClassification makeHourlyClassification(double hourlyRate);
	public abstract PaymentSchedule makeWeeklySchedule();
	public abstract PaymentMethod makeHoldMethod();
	public abstract PaymentClassification makeSalariedClassification(double salary);
	public abstract PaymentSchedule makeMonthlySchedule();
	public abstract PayrollFactory setPayrollFactory();
	public abstract PaymentSchedule makeBiWeeklySchedule();
	public abstract PaymentClassification makeCommissionedClassification(double salary, double commissionRate);
}
