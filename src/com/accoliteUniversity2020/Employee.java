/**
 * 
 */
package com.accoliteUniversity2020;

/**
 * @author abhishek
 *
 */
//import javax.xml.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
@XmlRootElement (name = "employee")
public class Employee {

	/**
	 * 
	 */
	private int employeeId;
	private String employeeName;
	private String assignedProject;
	private Sex employeeGender;
	private Department employeeDepartment;
	
	
	
	
	/**
	 * @param employeeId
	 * @param employeeName
	 * @param assignedProject
	 * @param employeeGender
	 * @param employeeDepartment
	 */
	public Employee(int employeeId, String employeeName, String assignedProject, Sex employeeGender,
			Department employeeDepartment) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.assignedProject = assignedProject;
		this.employeeGender = employeeGender;
		this.employeeDepartment = employeeDepartment;
	}




	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", assignedProject="
				+ assignedProject + ", employeeGender=" + employeeGender + ", employeeDepartment=" + employeeDepartment
				+ "]";
	}



	@XmlElement
	public int getEmployeeId() {
		return employeeId;
	}



	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	@XmlElement
	public String getEmployeeName() {
		return employeeName;
	}




	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}



	@XmlElement
	public String getAssignedProject() {
		return assignedProject;
	}




	public void setAssignedProject(String assignedProject) {
		this.assignedProject = assignedProject;
	}



	@XmlElement
	public Sex getEmployeeGender() {
		return employeeGender;
	}




	public void setEmployeeGender(Sex employeeGender) {
		this.employeeGender = employeeGender;
	}




	public Department getEmployeeDepartment() {
		return employeeDepartment;
	}




	public void setEmployeeDepartment(Department employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}




	public Employee() {
		// TODO Auto-generated constructor stub
	}

	
	public void update( Employee employee)
	{
		this.employeeId = employee.getEmployeeId();
		this.employeeName = employee.getEmployeeName();
		this.assignedProject = employee.getAssignedProject();
		this.employeeGender = employee.getEmployeeGender();
		this.employeeDepartment = employee.getEmployeeDepartment();
		
	}







	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (assignedProject == null) {
			if (other.assignedProject != null) {
				return false;
			}
		} else if (!assignedProject.equals(other.assignedProject)) {
			return false;
		}
		if (employeeDepartment != other.employeeDepartment) {
			return false;
		}
		if (employeeGender != other.employeeGender) {
			return false;
		}
		if (employeeId != other.employeeId) {
			return false;
		}
		if (employeeName == null) {
			if (other.employeeName != null) {
				return false;
			}
		} else if (!employeeName.equals(other.employeeName)) {
			return false;
		}
		return true;
	}

}
