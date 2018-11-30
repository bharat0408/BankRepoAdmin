package com.bank.model;

import org.springframework.format.annotation.DateTimeFormat;

public class Customer {
	private int customer_id;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String father_name;
	private String email_id;
	private long mobile_number;
	private long aadhar_card;
	private String date_of_birth;
	private int annual_income;

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public long getAadhar_card() {
		return aadhar_card;
	}

	public void setAadhar_card(long aadhar_card) {
		this.aadhar_card = aadhar_card;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public int getAnnual_income() {
		return annual_income;
	}

	public void setAnnual_income(int annual_income) {
		this.annual_income = annual_income;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", first_name=" + first_name + ", middle_name=" + middle_name
				+ ", last_name=" + last_name + ", father_name=" + father_name + ", email_id=" + email_id
				+ ", mobile_number=" + mobile_number + ", aadhar_card=" + aadhar_card + ", date_of_birth="
				+ date_of_birth + ", annual_income=" + annual_income + "]";
	}

}
