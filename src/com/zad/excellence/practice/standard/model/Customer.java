package com.zad.excellence.practice.standard.model;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = 2875831247643062511L;

	private int customerId;
	private String customerName;
	private String email;
	private String mobileNumber;

	public Customer(int customerId, String customerName, String email, String mobileNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
