/**
 * @author Pradeep 
 * Validates the Search Input for the presence of at least one criteria if no other
 * form input is received.
 *
 */

package com.webengage.hrms.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.webengage.hrms.model.Employee;

public class SearchValidator implements Validator {

	
	 
	public boolean supports(Class<?> clazz) {
		
		return Employee.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	
		Employee employee = (Employee) target;
		if(employee.getTitle()==null && employee.getLocation()==null && employee.getLocation()==null
				&& employee.getEmail()==null && employee.getWorkPhone()==null){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
					"required.name", "At least one criteria is required!");
		}
	

		
		
			


	}

}
