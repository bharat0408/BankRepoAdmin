package com.bank.model;

import java.util.List;

;

public class Account {

	
	private long account_number;
	private float balance;
	private String account_type;
	private long customer_id;

	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", balance=" + balance + ", account_type=" + account_type
				+ ", customer_id=" + customer_id + "]";
	}

	public long getAccount_number() {
		return account_number;
	}

	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

}
