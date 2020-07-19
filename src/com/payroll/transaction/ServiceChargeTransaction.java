package com.payroll.transaction;

import com.payroll.database.DatabaseFactory;
import com.payroll.domain.Affiliation;
import com.payroll.domain.Employee;
import com.payroll.domain.ServiceCharge;
import com.payroll.factory.impl.UnionAffiliation;
import com.payroll.transaction.application.Transaction;

public class ServiceChargeTransaction implements Transaction {
	private int memberId;
	private String date;
	private double charge;

	public ServiceChargeTransaction(int memberId, String date, double charge) {
		this.memberId = memberId;
		this.date = date;
		this.charge = charge;
	}

	@Override
	public void execute() {
		Employee emp = DatabaseFactory.DB_FACTORY_INSTANCE.getDatabase().getUnionMember(memberId);
		Affiliation af = emp.getAffiliation();
		if (af instanceof UnionAffiliation) {
			((UnionAffiliation) af).setServiceCharge(new ServiceCharge(this.date, this.charge));
		}

	}

}
