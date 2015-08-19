/** @author Pradeep 
 * This class retrieves employee information and handles redirects
 * to JSP pages.
 */


package com.webengage.hrms.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webengage.hrms.data.EmployeeDao;
import com.webengage.hrms.model.Employee;
import com.webengage.hrms.validator.SearchValidator;

@Controller
@RequestMapping(value = "/")
public class EmployeeContoller {

	
	 @Autowired
	  private EmployeeDao employeeDao;
	
	 @InitBinder
	 public void initBinder(WebDataBinder binder) {
		 //convert empty strings to nulls
	     binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	     //configure search validator

	     //binder.setValidator(new SearchValidator());
	     binder.addValidators(new SearchValidator());
	    // binder.(validators);
	 }
	 
	  @RequestMapping(method = RequestMethod.GET,value = "displayEditUser")
	    public String displayEditUser(@RequestParam(value="empId", required=true) int empId,Model model) {
		  Employee updateEmployee=employeeDao.findByEmpId(empId);
		  if(updateEmployee==null){
			  model.addAttribute("updateEmpMsg","Oops...Employee id not found!");  
			  model.addAttribute("updateEmployee",new Employee());
		  }else{
		  	model.addAttribute("updateEmployee",updateEmployee);
		  }	
			return "editEmployee";
	    }

	  @RequestMapping(method = RequestMethod.GET,value = "displayAddUser")
	    public String displayAddUser(Model model) {
		  
		  	model.addAttribute("newEmployee", new Employee());
			return "addEmployee";
	    }	  
	
	  @RequestMapping(method = RequestMethod.GET)
	    public String displayHomePage(Model model,Principal principal) {
		  	model.addAttribute("employeeSearch", new Employee());
		  	model.addAttribute("welcomeMsg",principal.getName());
	        return "home";
	    }
	  
	 @RequestMapping(method = RequestMethod.POST)
	    public String searchResults(@Valid  @ModelAttribute("employeeSearch") Employee employeeSearch,
	    		BindingResult result, Model model) {
		 
	        if (!result.hasErrors()) {
	        	System.out.println("employeeSearch="+employeeSearch);
	        	//the user keys in email without the domain information. Add domain information here.
	        	if(StringUtils.hasText(employeeSearch.getEmail())){
	        		employeeSearch.setEmail(employeeSearch.getEmail()+"@webengage.com");
	        	}
	            try {
	            	
	            	List<Employee> employeeList=employeeDao.findByCriteria(employeeSearch);
	            	 System.out.println("employee list size="+employeeList.size());
	            	model.addAttribute("employees", employeeList);
	              
	                return "home";
	            } catch (RuntimeException e) {
	                model.addAttribute("error", e.getCause().getCause());
	                return "index";
	            }
	        } else {
	            return "home";
	        }
	    }
	 

	 
}
