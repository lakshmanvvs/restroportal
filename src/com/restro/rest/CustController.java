package com.restro.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.restro.model.Customer;
import com.retro.dao.CustomerDAO;

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
	

}
