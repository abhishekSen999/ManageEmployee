/**
 * 
 */
package com.accoliteUniversity2020;

/**
 * @author abhishek
 *
 */
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/employeeService")
public class EmployeeService {
	
	
	
   EmployeeDatabaseManager employeeDatabaseManager = new EmployeeDatabaseManager();
   
   public EmployeeService()
   {
	   
   }
   
   
   @GET
   @Path("/employees")
   @Produces(MediaType.APPLICATION_XML)
   public ArrayList<Employee> getEmployees(){
      return employeeDatabaseManager.getAllEmployee();
   }

   @GET
   @Path("/employees/{employeeid}")
   @Produces(MediaType.APPLICATION_XML)
   public Employee getUser(@PathParam("employeeid") int employeeId){
      return employeeDatabaseManager.getEmployee(employeeId);
   }


   @OPTIONS
   @Path("/options")
   @Produces(MediaType.APPLICATION_XML)
   public String getSupportedOperations(){
      return "<operations>GET, PUT, POST, DELETE</operations>";
   }
}

