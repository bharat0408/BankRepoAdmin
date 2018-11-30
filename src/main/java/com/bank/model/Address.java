package com.bank.model;

public class Address {

	public Address() {
		super();
	}

	private int address_id;

	private String address_line_1;

	private String address_line_2;

	private String pin_code;

	private String state;

	private String city;

	private int customer_id;

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

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", address_line_1=" + address_line_1 + ", address_line_2="
				+ address_line_2 + ", pin_code=" + pin_code + ", state=" + state + ", city=" + city + ", customer_id="
				+ customer_id + "]";
	}

}
