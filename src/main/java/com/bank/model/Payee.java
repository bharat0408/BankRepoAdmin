package com.bank.model;

public class Payee {

	private long payee_account_number;
	private String name;
	private String nick_name;
	private long customer_account_number;

	public long getPayee_account_number() {
		return payee_account_number;
	}

	public void setPayee_account_number(long payee_account_number) {
		this.payee_account_number = payee_account_number;
	}

	public long getCustomer_account_number() {
		return customer_account_number;
	}

	/*
	 * public void setCustomer_account_number(String customer_account_number) {
	 * this.customer_account_number = Long.parseLong(customer_account_number); }
	 */
	public void setCustomer_account_number(long customer_account_number) {
		this.customer_account_number = customer_account_number;
	}

	public void setPayee_account_number(int payee_account_number) {
		this.payee_account_number = payee_account_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public void setCustomer_account_number(int customer_account_number) {
		this.customer_account_number = customer_account_number;
	}

	@Override
	public String toString() {
		return "Payee [payee_account_number=" + payee_account_number + ", name=" + name + ", nick_name=" + nick_name
				+ ", customer_account_number=" + customer_account_number + "]";
	}

}
