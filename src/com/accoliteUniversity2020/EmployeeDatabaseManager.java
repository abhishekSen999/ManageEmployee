/**
 * 
 */
package com.accoliteUniversity2020;

/**
 * @author abhishek
 *
 */
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import javax.xml.bind.annotation.XmlElement;


@XmlRootElement(name = "employees")
class EmployeeDatabaseManager {

	/**
	 * 
	 */
	//private Employees employees ;
	
	@XmlElement( name = "employee" )
	private ArrayList<Employee> listOfEmployees;
	
	
	public EmployeeDatabaseManager() {
		// TODO Auto-generated constructor stub
		//employees = new Employees();
		listOfEmployees = null;
	}
	
	/**
	 * @return the listOfEmployees
	 */
	public ArrayList<Employee> getListOfEmployees() {
		return listOfEmployees;
	}

	/**
	 * @param listOfEmployees the listOfEmployees to set
	 */
	public void setListOfEmployees(ArrayList<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}
	
	
	
	
	public ArrayList<Employee> getAllEmployee() // unmarshalling all employees from XML File
	{
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeDatabaseManager.class);
		    Unmarshaller jaxbUn = jaxbContext.createUnmarshaller();
		    EmployeeDatabaseManager employees = (EmployeeDatabaseManager) jaxbUn.unmarshal( new File("/home/abhishek/GIT/eclipse-workspace/ManageEmployee/XmlDatabase/employees.xml"));
		    this.listOfEmployees = employees.listOfEmployees; // updating list of employees from xml return 
		}
		catch (JAXBException exception)
		{
			exception.printStackTrace();
		}
		return listOfEmployees;// returning ArrayList of employees
	}
	
	private void saveAllEmployee() // marshalling employees object to XML File
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeDatabaseManager.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    jaxbMarshaller.marshal(this , new File("/home/abhishek/GIT/eclipse-workspace/ManageEmployee/XmlDatabase/employees.xml"));
		}
		catch(JAXBException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	public Employee getEmployee( int employeeId ) // Handling Retrieve - GET
	{
		ArrayList<Employee> listOfEmployees = this.getAllEmployee();
		
		for (Employee employee : listOfEmployees)
		{
			if ( employee.getEmployeeId() == employeeId )
				return employee;
		}
		return null;
	}
	
	public int addEmployee( Employee employee ) // Handling Create - PUT
	{
		boolean employeeExists = false;
		
		ArrayList<Employee> listOfEmployees = this.getAllEmployee();
		
		for(Employee employeeIterator: listOfEmployees)
		{
			if ( employeeIterator.getEmployeeId() == employee.getEmployeeId())
			{
				employeeExists = true;
				break;
			}
		}
		
		if(!employeeExists)
		{
			listOfEmployees.add( employee );
			this.saveAllEmployee();
			return 1;
		}	
		return 0;
	}
	
	
	public int updateEmployee ( Employee employee ) // Handeling update - POST
	{
		boolean employeeExists = false;
		
		ArrayList<Employee> listOfEmployees = this.getAllEmployee();
		Employee employeeToUpdate = null;
		for(Employee employeeIterator: listOfEmployees)
		{
			if ( employeeIterator.getEmployeeId() == employee.getEmployeeId())
			{
				employeeToUpdate = employeeIterator;
				employeeExists = true;
				break;
			}
		}
		if(employeeExists) {
			employeeToUpdate.update(employee);
			saveAllEmployee();
			return 1 ; 
		}
		return 0;
	}
	
	
	public int deleteEmployee(int employeeId) // Handling Delete -- DELETE
	{
		boolean employeeExists = false;
		
		ArrayList<Employee> listOfEmployees = this.getAllEmployee();
		int indexOfEmployeeToDelete = -1;
		for(Employee employeeIterator: listOfEmployees)
		{
			if ( employeeIterator.getEmployeeId() == employeeId)
			{
				indexOfEmployeeToDelete = listOfEmployees.indexOf(employeeIterator);
				employeeExists = true;
				break;
			}
		}
		if(employeeExists) {
			listOfEmployees.remove(indexOfEmployeeToDelete);
			saveAllEmployee();
			return 1 ; 
		}
		
		
		return 0;
	}
	
	

	
	
	
	
	
	
	

}
