package com.webengage.hrms.data;

import java.util.List;

import com.webengage.hrms.model.Employee;
/**
 * @author Pradeep
 * Employee Dao Interface for data access methods
 */
public interface EmployeeDao {

	public void add(Employee employee);
	
	public void update(Employee employee);
	
	public void delete(int empId);
	
	public List<Employee> findByCriteria(Employee employee);
	
	public Employee findByEmpId(int empId);
	
	
}
