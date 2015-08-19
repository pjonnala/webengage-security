/**
 * Responsible for INSERT,SAVE AND UPDATE of Employee
 * @author Pradeep
 *
 */

package com.webengage.hrms.controller;


import javax.persistence.OptimisticLockException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.webengage.hrms.data.EmployeeDao;
import com.webengage.hrms.model.Employee;
import com.webengage.hrms.validator.EmployeeSaveValidator;



@Controller
@RequestMapping(value = "/")
public class EmployeeSaveController {

	 @Autowired
	  private EmployeeDao employeeDao;;
	  
	  @InitBinder
		 public void initBinder(WebDataBinder binder) {
			 //convert empty strings to nulls
		     binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		     // add update validation
		     binder.addValidators(new EmployeeSaveValidator());
		}
		 
	 
		 @RequestMapping(method = RequestMethod.POST,value="addUser")
		    public String addUser(@Valid  @ModelAttribute("newEmployee") Employee newEmployee,
		    		BindingResult result, Model model) {
			 
		        if (!result.hasErrors()) {
		        
		            try {
		            
		            		newEmployee.setEmail(newEmployee.getEmail()+"@webengage.com");
		            		/*set default password. This is a temporary hack. 
		            		 * Encrypt it using spring crypto  using MD5 or SHA1 hashing 
		            		 */
		            	  newEmployee.setPassword("password");
		            	  //later implementation use active from the form
		            	  newEmployee.setActive(true);
		            	  employeeDao.add(newEmployee);
		            	  Employee initNewEmployee= new Employee();
		            	  initNewEmployee.setEmpId(newEmployee.getEmpId());
		            	  //TODO use log4j 
		            	  System.out.println("newEmployee after insert"+newEmployee);
		            	  
		            	  model.addAttribute("newEmployee", initNewEmployee);
		            	  //TODO externalize using property file
		            	  model.addAttribute("newEmpSuccessMsg","New employee id "+newEmployee.getEmpId() +" added");
		                return "addEmployee";
		            } catch (RuntimeException e) {
		                model.addAttribute("error", e.getCause().getCause());
		                return "addEmployee";
		            }
		        } else {
		        	 System.out.println("New employee errors");
		        	  model.addAttribute("newEmployee", new Employee());
		        	 
		            return "addEmployee";
		        }
		    }
		 

		 @RequestMapping(method = RequestMethod.POST,value="updateUser")
		    public String updateUser(@Valid  @ModelAttribute("updateEmployee") Employee updateEmployee,
		    		BindingResult result, Model model) {
			 
		        if (!result.hasErrors()) {
		        
		            try {
		            	  employeeDao.update(updateEmployee);
		            	  System.out.println("newEmployee after update"+updateEmployee);
		            	  
		            	  model.addAttribute("updateEmployee", updateEmployee);
		            	  //TODO externalize using property file
		            	  model.addAttribute("updateEmpMsg","Employee updated ");
		                return "editEmployee";
		            } catch (OptimisticLockException e) {
		            	model.addAttribute("updateEmployee",employeeDao.findByEmpId(updateEmployee.getEmpId()));
		                model.addAttribute("updateEmpMsg", "Oops..Someone else updated your record. See changes below");
		                return "editEmployee";
		            }
		            catch (RuntimeException e) {
		            	model.addAttribute("error", e.getCause().getCause());
		                return "editEmployee";
		            }
		        } else {
		        	 System.out.println("New employee errors");
		        	  model.addAttribute("updateEmployee", updateEmployee);
		        	 
		            return "editEmployee";
		        }
		    }
		 
		  @RequestMapping(method = RequestMethod.POST,value = "deleteUser")
		    public String deleteUser(@Valid  @ModelAttribute("updateEmployee") Employee deleteEmp,Model model) {
		
			  
			  if(employeeDao.findByEmpId(deleteEmp.getEmpId())==null){
				  model.addAttribute("deleteUsrMsg","Oops...Employee id not found!");  
			  }else{
				  try{
					  employeeDao.delete(deleteEmp.getEmpId());
					  model.addAttribute("employeeSearch",new Employee());
					  model.addAttribute("deleteUsrMsg","Employee deleted succesfully");
				  }
				  catch (RuntimeException e) {
			            	model.addAttribute("error", e.getCause().getCause());
			                return "editEmployee";
			      }
				
			  }	
				
			  return "home";
		    }			 
}
