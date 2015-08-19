/**
 * @author Pradeep
 * Interface Class for service layer.
 */
package com.webengage.hrms.services;

import java.util.List;

import com.webengage.hrms.model.Employee;

public interface EmployeeService {

public void add(Employee employee);
	
	public void update(Employee employee);
	
	public void delete(int empId);
	
	public List<Employee> findByCriteria(Employee employee);
	
	public Employee findByEmpId(int empId);
}
