package com.bank.model;

import java.sql.Date;

import org.springframework.jdbc.core.JdbcTemplate;

public class Transaction {

	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private long reference_id;
	private String type;
	private int amount;
	private long from_account;
	private long to_account;
	private Date timestamp;
	private String remark;
	private float charges;
	private String payee_name;
	private String status;
	
	
	

	@Override
	public String toString() {
		return "Transaction [jdbcTemplate=" + jdbcTemplate + ", reference_id=" + reference_id + ", type=" + type
				+ ", amount=" + amount + ", from_account=" + from_account + ", to_account=" + to_account
				+ ", timestamp=" + timestamp + ", remark=" + remark + ", charges=" + charges + ", payee_name="
				+ payee_name + ", status=" + status + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	public long getFrom_account() {
		return from_account;
	}

	public void setFrom_account(long from_account) {
		this.from_account = from_account;
	}

	public String getPayee_name() {
		return payee_name;
	}

	public void setPayee_name(String payee_name) {
		this.payee_name = payee_name;
	}

	public long getTo_account() {
		return to_account;
	}

	public void setTo_account(long to_account) {
		this.to_account = to_account;
	}

	public long getReference_id() {
		return reference_id;
	}

	public void setReference_id(long reference_id) {
		this.reference_id = reference_id;
	}

	public float getCharges() {
		return charges;
	}

	public void setCharges(float charges) {
		this.charges = charges;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date date) {
		this.timestamp = date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
