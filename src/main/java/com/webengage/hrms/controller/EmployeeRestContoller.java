/**	@author Pradeep
 * This class serves all the restful requests
 */

package com.webengage.hrms.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webengage.hrms.data.EmployeeDao;
import com.webengage.hrms.model.Employee;


@Controller
@RequestMapping(value = "/rest/employee")
public class EmployeeRestContoller {

	@Autowired
	  private EmployeeDao employeeDao;
	
	
	  @RequestMapping(value = "/{empId}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody Employee lookupEmployeeById(@PathVariable("empId") int empId) {
		 	return employeeDao.findByEmpId(empId);
	        
	    }
	  
	  @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	    public @ResponseBody Employee addEmployee(
	    		@RequestParam(value="name", required=true) String name,
	    		@RequestParam(value="title", required=true) String title,
	    		@RequestParam(value="location", required=true) String location,
	    		@RequestParam(value="email", required=true) String email, 
	    		@RequestParam(value="workPhone", required=true) String workPhone 
	    ) {
		  
		  Employee addEmp= new Employee();
		  addEmp.setPassword("password");
		  addEmp.setName(name);
		  addEmp.setTitle(title);
		  addEmp.setLocation(location);
		  addEmp.setEmail(email);
		  addEmp.setWorkPhone(workPhone);
		  employeeDao.add(addEmp);
		 	return addEmp;
	        
	    }
	  
}
