package com.restro.model;

import java.util.Date;

public class Customer {
	
	private int confirmCode;
	private String firstName;
	private String lastName;
	private Date reserveDate;
	private int partySize;
	private String phone;
	private String status;
	
	public int getConfirmCode() {
		return confirmCode;
	}
	public void setConfirmCode(int confirmCode) {
		this.confirmCode = confirmCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}
	public int getPartySize() {
		return partySize;
	}
	public void setPartySize(int partySize) {
		this.partySize = partySize;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
