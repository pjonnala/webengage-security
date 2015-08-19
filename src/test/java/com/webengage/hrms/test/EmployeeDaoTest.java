/** 
 * @author Pradeep
 * This class provides the test functionality to test EmployeeDao
 */
package com.webengage.hrms.test;

import java.util.List;

import com.webengage.hrms.data.EmployeeDao;
import com.webengage.hrms.model.Employee;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml",
                                   "classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class EmployeeDaoTest {
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testFindById() {
        Employee employee = employeeDao.findByEmpId(5);

        assertEquals("Joan Rivers", employee.getName());
        assertEquals("jrivers@webengage.com", employee.getEmail());
        assertEquals("Houston,Texas", employee.getLocation());
        assertEquals("HR Analyst", employee.getTitle());
        assertEquals("281-220-2123", employee.getWorkPhone());
        assertEquals("281-675-5642", employee.getHomePhone());
        assertEquals("281-341-2345", employee.getCellPhone());
        assertTrue(employee.isActive());
        return;
    }	

     @Test
    public void testFindByName() {
        Employee employee = new Employee();
        employee.setName("freeman");
        List<Employee> employees=employeeDao.findByCriteria(employee);
        assertEquals(employees.size(),2);
        return;
    }

     
     @Test
    public void testFindByTitleAndLocation() {
        Employee employee = new Employee();
        employee.setTitle("HR");
        employee.setLocation("Texas");
        List<Employee> employees=employeeDao.findByCriteria(employee);
        assertEquals(employees.size(),3);
        return;
    }     
  
     @Test
    public void testFindByEmail() {
        Employee employee = new Employee();
        employee.setEmail("mfreeman@webengage.com");
        List<Employee> employees=employeeDao.findByCriteria(employee);
        assertEquals(employees.size(),1);
        return;
    }     
     
     @Test
    public void testFindByCriteria() {
        Employee employee = new Employee();
        employee.setName("kubrick");
        employee.setTitle("director");
        employee.setLocation("Stamford,Connecticut");
        employee.setEmail("skubrick@webengage.com");
        employee.setWorkPhone("203-215-3456");        
        List<Employee> employees=employeeDao.findByCriteria(employee);
        assertEquals(employees.size(),1);
        return;
    }     
       
    @Test
    public void testAdd() {
        Employee employee = new Employee();
        
       
        employee.setPassword("default password");
        employee.setName("Cathy Lee");
        employee.setLocation("Birmingham, Alabama");
        employee.setEmail("cathylee@webengage.com");
        employee.setTitle("Senior Manager, Marketing");
        employee.setWorkPhone("205-220-2100");
        employee.setHomePhone("205-754-2123");
        employee.setCellPhone("205-777-1542");
        employee.setActive(true);

        employeeDao.add(employee);
        List<Employee> empList=employeeDao.findByCriteria(employee);
        assertEquals(empList.size(),1);
        assertEquals(empList.get(0).getName(),"Cathy Lee");
        System.out.println("empList.get(0).getAddTimeStamp()="+empList.get(0).getAddTimeStamp());
        assertNotNull(empList.get(0).getAddTimeStamp());
        assertNull(empList.get(0).getUpdateTimeStamp());
        
           return;
    }

    @Test
    public void testUpdate() {
        Employee employee = new Employee();
        
        employee.setEmpId(9);
        employee.setLocation("Oslo, Norway");
        employee.setTitle("Greatest director");
     

        employeeDao.update(employee);
        
        Employee updatedEmployee =employeeDao.findByEmpId(9);
        assertEquals("Greatest director", updatedEmployee.getTitle());
        assertEquals("Oslo, Norway", updatedEmployee.getLocation());
        assertNotNull(updatedEmployee.getUpdateTimeStamp());

    }

    @Test
    public void testDelete() {
      
        employeeDao.delete(8);
      
        Employee deletedEmployee =employeeDao.findByEmpId(8);
        assertNull(deletedEmployee);

      

    }
}