package com.payroll.database;

import com.payroll.domain.Employee;

public interface Database {
	public void addEmployee(int id, Employee e);
	public Employee getEmployee(int empId);
	public void removeEmployee(int empId);
	public void addUnionMember(int memberId, Employee emp);
	public Employee getUnionMember(int memberId);
}
