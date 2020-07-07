package com.payroll.transaction;

import com.payroll.database.PayrollDatabase;

public class DeleteEmployeeTransaction implements Transaction {
	int empId;

	public DeleteEmployeeTransaction(int empId) {
		this.empId = empId;
	}

	@Override
	public void execute() {
		PayrollDatabase.removeEmployee(empId);

	}

}
