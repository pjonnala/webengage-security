/**
 * @author Pradeep
 * This class represents the JPA entity which is mapped to employee table. This
 * class is also has field level validation  provided by JSR 303 for
 * bean validation
 */

package com.webengage.hrms.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Employee implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
    @Column(name = "emp_id")
    @GeneratedValue
    private int empId;


    private String password;


    @Size(min = 3, max = 25)
    @Pattern(regexp = "[A-Za-z ]*", message = "name must contain only letters and spaces")
    private String name;
    
    
 	private String title;

    private String location;

    @Pattern(regexp = "[A-Za-z ]*", message = "name must contain only letters and spaces")
    private String email;
    
    

    @Column(name = "work_phone")
    private String workPhone;
    
    @Column(name = "home_phone")
    private String homePhone;
    
    @Column(name = "cell_phone")
    private String cellPhone;
   
    @Column(name = "add_ts",insertable =true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)    
	private Date addTimeStamp;

    @Column(name = "upd_ts",insertable = false, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTimeStamp;
    
    @Version 
   
    private long version;
    
  
	
	private boolean active;
    

    public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
    public Date getAddTimeStamp() {
		return addTimeStamp;
	}
    
	public void setAddTimeStamp(Date addTimeStamp) {
		this.addTimeStamp = addTimeStamp;
	}
	
	public Date getUpdateTimeStamp() {
		return updateTimeStamp;
	}
	
	public void setUpdateTimeStamp(Date updateTimeStamp) {
		this.updateTimeStamp = updateTimeStamp;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}	
	
	public long getVersion() {
			return version;
	}
	public void setVersion(long version) {
			this.version = version;
	}
  

	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", password=" + password + ", name=" + name + ", title=" + title
				+ ", location=" + location + ", email=" + email + ", workPhone=" + workPhone + ", homePhone="
				+ homePhone + ", cellPhone=" + cellPhone + ", addTimeStamp=" + addTimeStamp + ", updateTimeStamp="
				+ updateTimeStamp + ", version=" + version + ", active=" + active + "]";
	}
}
