package com.employeemanagement;

import java.util.List;

public interface EmployeeDAO {

	void addEmployee(Employee e);
	void updateEmployee(Employee e);
	void deleteEmployee(int id);
	Employee searchEmployee(int id);
	List<Employee> displayAllEmployees();

}