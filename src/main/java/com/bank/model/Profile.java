package com.bank.model;

public class Profile {
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

	private long account_number;
	private float balance;
	private String account_type;
	
	
	private int address_id;
	private String address_line_1;
	private String address_line_2;
	private String pin_code;
	private String state;
	private String city;
	
	
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
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public int getAnnual_income() {
		return annual_income;
	}
	public void setAnnual_income(int annual_income) {
		this.annual_income = annual_income;
	}
	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
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
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getAddress_line_1() {
		return address_line_1;
	}
	public void setAddress_line_1(String address_line_1) {
		this.address_line_1 = address_line_1;
	}
	public String getAddress_line_2() {
		return address_line_2;
	}
	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}
	public String getPin_code() {
		return pin_code;
	}
	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Profile [customer_id=" + customer_id + ", first_name=" + first_name + ", middle_name=" + middle_name
				+ ", last_name=" + last_name + ", father_name=" + father_name + ", email_id=" + email_id
				+ ", mobile_number=" + mobile_number + ", aadhar_card=" + aadhar_card + ", date_of_birth="
				+ date_of_birth + ", annual_income=" + annual_income + ", account_number=" + account_number
				+ ", balance=" + balance + ", account_type=" + account_type + ", address_id=" + address_id
				+ ", address_line_1=" + address_line_1 + ", address_line_2=" + address_line_2 + ", pin_code=" + pin_code
				+ ", state=" + state + ", city=" + city + "]";
	}
	
	
	
	
	

}
