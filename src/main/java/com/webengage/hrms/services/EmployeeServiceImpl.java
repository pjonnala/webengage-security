package com.webengage.hrms.services;

import java.util.List;

import javax.persistence.OptimisticLockException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webengage.hrms.data.EmployeeDao;
import com.webengage.hrms.model.Employee;

@Service 
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	//@Transactional
	public void add(Employee employee) {
		employeeDao.add(employee);
	}

	@Override
	@Transactional
	public void update(Employee employee) {
		
		employeeDao.update(employee);
		
	}

	@Override
	@Transactional
	public void delete(int empId) {
		employeeDao.delete(empId);
		
	}

	@Override
	public List<Employee> findByCriteria(Employee employee) {
		return employeeDao.findByCriteria(employee);
	
	}

	@Override
	public Employee findByEmpId(int empId) {
		
		return employeeDao.findByEmpId(empId);
	}

}
