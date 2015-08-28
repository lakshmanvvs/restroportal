package com.restro.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.restro.dao.CustomerDAO;
import com.restro.model.*;

@Path("/owner")
public class OwnerController {
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getAll() {
		
		 CustomerDAO dao = new CustomerDAO();
		 List<Customer> custList = dao.getAll();
		
		return custList;
	}
	
	@POST 
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public String login(LoginOwner lown, @Context HttpServletRequest request){
		CustomerDAO dao = new CustomerDAO();
		     String result =    dao.login(lown);
		        
		     HttpSession session = request.getSession(true);
		     session.setAttribute("username", lown);
		
		
		return result;
				
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
