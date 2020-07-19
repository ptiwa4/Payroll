package com.payroll.database;

import java.util.HashMap;
import java.util.Map;

import com.payroll.domain.Employee;

public class TestDatabase implements Database {
	private Map<Integer, Employee> mapEmp;
	private Map<Integer, Employee> mapUnion;

	public TestDatabase() {
		mapEmp = new HashMap<>();
		mapUnion = new HashMap<>();
	}

	public void addEmployee(int id, Employee e) {
		mapEmp.put(id, e);

	}

	public Employee getEmployee(int empId) {
		Employee e = mapEmp.get(empId);
		return e;
	}

	public void removeEmployee(int empId) {
		mapEmp.remove(empId);

	}

	public void addUnionMember(int memberId, Employee emp) {
		mapUnion.put(memberId, emp);
	}

	public Employee getUnionMember(int memberId) {
		Employee e = mapUnion.get(memberId);
		return e;
	}
}
