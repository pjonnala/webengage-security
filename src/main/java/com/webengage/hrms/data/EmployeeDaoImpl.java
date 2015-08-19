/** 
 * @author Pradeep
 * This class has CRUD logic for Employee entity
 */

package com.webengage.hrms.data;
import com.webengage.hrms.model.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;






//TODO add log4j logging
//TODO Add class level and method level comments
@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	 @Autowired
	 private EntityManager em;	
	 
	 
	public void add(Employee employee) {
		 
		 
	//	em.get
		//TODO put this code in date utils function
		Date date= new Date();
		 employee.setAddTimeStamp(date);
		try{
	
	//	em.getTransaction().begin();			
	//    em.persist(employee);
	    em.persist(employee);
	  //  em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		 

	}

	@Override
	
	//@todo handle timestamp
	public void update(Employee employee) {
					Employee dbempRecord = em.find(Employee.class, employee.getEmpId());
			 		 //prevents concurrent updates by checking for verison number changes
					 em.lock(dbempRecord, LockModeType.OPTIMISTIC);
		 	 		 dbempRecord.setName(employee.getName());
					 dbempRecord.setTitle(employee.getTitle());
					 dbempRecord.setLocation(employee.getLocation());
					 dbempRecord.setEmail(employee.getEmail());
					 dbempRecord.setWorkPhone(employee.getWorkPhone());
					 dbempRecord.setHomePhone(employee.getHomePhone());
					 dbempRecord.setCellPhone(employee.getCellPhone());
					 //TODO put in a utility method
					 Date date= new Date();
					 dbempRecord.setUpdateTimeStamp(date);
		
	}

	@Override
	public void delete(int empId) {
		
		em.remove(findByEmpId(empId));

	}

	
	@Override
	//TODO handle 'like' in the where clause
	public List<Employee> findByCriteria(Employee employee) {

	
		 CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Employee> c = cb.createQuery(Employee.class);
	        Root<Employee> empRoot = c.from(Employee.class);
	        c.select(empRoot);
	        List<Predicate> criteria = new ArrayList<Predicate>();
	        
	    	String name=employee.getName();
			String title=employee.getTitle();
			String location=employee.getLocation();
			String email=employee.getEmail();
			String workPhone=employee.getWorkPhone();
			
	        
	        if (name != null) {
	            ParameterExpression<String> p =
	                cb.parameter(String.class, "name");
	         
	            criteria.add(cb.like(cb.upper(empRoot.<String>get("name")), "%"+name.toUpperCase()+"%"));
	        }
	       
	        if (title != null) {
	            ParameterExpression<String> p =
	                cb.parameter(String.class, "title");
	            criteria.add(cb.like(cb.upper(empRoot.<String>get("title")), "%"+title.toUpperCase()+"%"));
	        }
	        if (location != null) {
	            ParameterExpression<String> p =
	                cb.parameter(String.class, "location");
	            criteria.add(cb.like(cb.upper(empRoot.<String>get("location")), "%"+location.toUpperCase()+"%"));
	           
	        }
	        if (email != null) {
	            ParameterExpression<String> p =
	                cb.parameter(String.class, "email");
	            criteria.add(cb.equal(empRoot.get("email"), email.toUpperCase()));
	        }

	        if (workPhone != null) {
	            ParameterExpression<String> p =
	                cb.parameter(String.class, "workPhone");
	            criteria.add(cb.like(cb.upper(empRoot.<String>get("workPhone")), "%"+workPhone.toUpperCase()+"%"));
	          
	        }
	        
	        if (criteria.size() == 0) {
	            throw new RuntimeException("no criteria");
	        } else if (criteria.size() == 1) {
	           c.where(criteria.get(0));
	        } else {
	            c.where(cb.and(criteria.toArray(new Predicate[0])));
	        }
	        
	        //The query limits the results to 50 to optimize data retrieval of 30 thousand employees
	        //TODO externalize the 50 to a property file, JNDI or DB
	        TypedQuery<Employee> q = em.createQuery(c).setMaxResults(50);
	        
	        return q.getResultList();
	        
	

	    }

	@Override
	public Employee findByEmpId(int empId) {
	
		 return em.find(Employee.class, empId);
	}

	}


