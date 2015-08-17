package com.restro.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
				cust.setPhone(rs.getString("PHONE"));
				cust.setStatus(rs.getString("TABLE_STATUS"));
				
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
			  
			  cust.setStatus("Customer has been deleted from database");
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

}
