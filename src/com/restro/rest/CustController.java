package com.restro.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.restro.dao.CustomerDAO;
import com.restro.model.Customer;

@Path("/customer")
public class CustController {
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getAll() {
		
		 CustomerDAO dao = new CustomerDAO();
		 List<Customer> custList = dao.getAll();
		
		return custList;
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@PathParam("id") int confirmCode){
		
		CustomerDAO dao = new CustomerDAO();
		 Customer cust  = dao.getAll(confirmCode);
		
		return cust;
	}
	
	@POST
	@Path("/reservetable")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String reserveTable(Customer cust) {
		CustomerDAO dao = new CustomerDAO();
		cust =  dao.addCustomer(cust);
		
	 
		return  "User added to database"; 
	}
	
	@PUT
	@Path("/edittable/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Customer editTable(Customer cust, @PathParam("id") int confirmCode){
		CustomerDAO dao = new CustomerDAO();
		  cust =  dao.editCustomer(cust, confirmCode);
		
		
		return cust;
		
	}
	
	
	@DELETE
	@Path("/reserve/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> delete(@PathParam("id") int confirmCode) {
		
		 CustomerDAO dao = new CustomerDAO();
		  List<Customer> cust = dao.DeleteCustomer(confirmCode);
		
		
		
		return cust;
	}

}
