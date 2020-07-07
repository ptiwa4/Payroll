package com.payroll.database;

import java.util.HashMap;
import java.util.Map;

import com.payroll.model.Employee;

public class PayrollDatabase {

	private static Map<Integer, Employee> mapEmp  = new HashMap<>();
	
	
	public static void addEmployee(int id, Employee e) {
		mapEmp.put(id, e);
		
	}


	public static Employee getEmployee(int empId) {
		Employee e = mapEmp.get(empId);
		return e;
	}


	public static void removeEmployee(int empId) {
		mapEmp.remove(empId);
		
	}
}
