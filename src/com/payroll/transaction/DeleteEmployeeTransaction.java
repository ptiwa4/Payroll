package com.payroll.transaction;

import com.payroll.database.DatabaseFactory;
import com.payroll.transaction.application.Transaction;

public class DeleteEmployeeTransaction implements Transaction {
	int empId;

	public DeleteEmployeeTransaction(int empId) {
		this.empId = empId;
	}

	@Override
	public void execute() {
		DatabaseFactory.DB_FACTORY_INSTANCE.getDatabase().removeEmployee(empId);
	}

}
