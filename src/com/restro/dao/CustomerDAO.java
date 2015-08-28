package com.restro.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.sql.PreparedStatement;
import com.restro.model.*;
import com.restro.utils.DBUtil;

public class CustomerDAO {
	
	public List<Customer> getAll() {
		List<Customer> custList = new ArrayList<Customer>();
		
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("SELECT *, table_status FROM reserve_table,tables_list where reserve_table.confirm_code=tables_list.table_id");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer cust = new Customer();
				Tables tabl = new Tables();
				
				cust.setConfirmCode(rs.getInt("CONFIRM_CODE"));
				cust.setFirstName(rs.getString("FIRST_NAME"));
				cust.setLastName(rs.getString("LAST_NAME"));
				cust.setReserveDate(rs.getDate("RESERVE_DATE"));
				cust.setPartySize(rs.getInt("PARTY_SIZE"));						
				cust.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				//cust.setStatus(rs.getString("TABLE_STATUS"));
				tabl.setStatus(rs.getString("TABLE_STATUS"));
				
				custList.add(cust);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			DBUtil.closeResources(ps, rs, con);
		}
		
		return custList;
	}
	
	public Customer getAll(int confirmCode) {
		Customer cust = new Customer();
		
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM reserve_table where confirm_code= ?");
			  ps.setInt(1, confirmCode);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				//Customer cust = new Customer();
				//Tables tabl = new Tables();
				
				cust.setConfirmCode(rs.getInt("CONFIRM_CODE"));
				cust.setFirstName(rs.getString("FIRST_NAME"));
				cust.setLastName(rs.getString("LAST_NAME"));
				cust.setReserveDate(rs.getDate("RESERVE_DATE"));
				cust.setPartySize(rs.getInt("PARTY_SIZE"));						
				cust.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				//cust.setStatus(rs.getString("TABLE_STATUS"));
				//tabl.setStatus(rs.getString("TABLE_STATUS"));
				
				//custList.add(cust);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			DBUtil.closeResources(ps, rs, con);
		}
		
		return cust;
	}
	
	public Customer addCustomer(Customer cust) {
		
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("INSERT INTO reserve_table (first_name,last_name, reserve_date,party_size, phone_number) VALUES (?,?,?,?,?) ", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, cust.getFirstName());
			ps.setString(2, cust.getLastName());
			ps.setDate(3, (Date) cust.getReserveDate());
			ps.setInt(4, cust.getPartySize());
			ps.setString(5, cust.getPhoneNumber());
			
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				cust.setConfirmCode(rs.getInt(1));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtil.closeResources(ps, rs, con);
		}
		
		return cust;
	}
	
public Customer editCustomer(Customer cust, int Confirmcode) {
		
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("UPDATE reserve_table SET FIRST_NAME = ? , LAST_NAME = ?, RESERVE_DATE =? , PARTY_SIZE =? ,PHONE_NUMBER = ?"
					+ " WHERE CONFIRM_CODE=? ");
			ps.setString(1, cust.getFirstName());
			ps.setString(2, cust.getLastName());
			ps.setDate(3, (Date) cust.getReserveDate());
			ps.setInt(4, cust.getPartySize());
			ps.setString(5, cust.getPhoneNumber());
			ps.setInt(6, Confirmcode);
			
			ps.executeUpdate();
			//rs = ps.getGeneratedKeys();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtil.closeResources(ps, rs, con);
		}
		
		return cust;
	}
	
	
	public List<Customer> DeleteCustomer(int confirmCode){
		
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customer> custList = new ArrayList<Customer>();
		
		try {
			Customer cust = new Customer();
			ps = con.prepareStatement("DELETE  FROM RESERVE_TABLE WHERE CONFIRM_CODE =?");
			  ps.setInt(1, confirmCode);
			  ps.executeUpdate();
			  
			 // cust.setStatus("Customer has been deleted from database");
			  cust.setConfirmCode(confirmCode);
			  custList.add(cust);
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			DBUtil.closeResources(ps, rs, con);
		}
		
		return custList;
			
	}
	
	public String login(LoginOwner lown){
		
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("SELECT *  FROM OWNER_LOGIN WHERE USERNAME =? AND PASSWORD=?");
			
	    String oname =lown.getUsername();
	    String opwd = lown.getPassword();
	    
	     ps.setString(1, oname);
	     ps.setString(2, opwd);
	    
	    System.out.println("Username is " +oname);
	    System.out.println("Password is " +opwd);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
		 String pword = rs.getString("password");
		 String uname = rs.getString("username");
		 if(uname.equals(oname) && pword.equals(opwd)){
				
			   return "Valid login";
		   }
		  
		 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Invalid credentials";
		
	}

}
