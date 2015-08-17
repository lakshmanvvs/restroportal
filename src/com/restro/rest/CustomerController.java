package com.restro.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.restro.model.*;
import com.retro.dao.CustomerDAO;

@Path("/owner")
public class CustomerController {
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getAll() {
		
		 CustomerDAO dao = new CustomerDAO();
		 List<Customer> custList = dao.getAll();
		
		return custList;
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
