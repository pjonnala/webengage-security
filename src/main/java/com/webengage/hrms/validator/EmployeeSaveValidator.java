/**
 * @author Pradeep
 * This class ensures that all the required fields on employee are provided for 
 * front end validation
 */

package com.webengage.hrms.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.webengage.hrms.model.Employee;

public class EmployeeSaveValidator implements Validator{

	

	 
	public boolean supports(Class<?> clazz) {
		
		return Employee.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
	//TODO externalize messages for application resources
		Employee employee = (Employee) target;
		
		if(employee.getName()==null){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
					"required.name", "Name, Title, Location, Email, Work Phone required");
	
		}
		
		
		if(employee.getTitle()==null){
		
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
					"required.title", "Title is required!");
		}
		
		if(employee.getLocation()==null){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location",
					"required.location", "Location is required!");
		}
		
		if(employee.getEmail()==null){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
					"required", "Email is required!");
		}	
		
		if(employee.getWorkPhone()==null){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "workPhone",
					"required", "Work Phone is required!");
		}	
		
	
	
    }
 }	
	
