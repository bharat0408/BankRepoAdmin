package com.bank.model;

public class InternetBankingUser {

	private String user_id;

	private String login_password;

	private String transaction_password;

	private int attempts;

	private String status;

	private String security_questions;

	private String security_answers;

	private long account_number;

	public long getAccount_number() {
		return account_number;
	}

	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getLogin_password() {
		return login_password;
	}

	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}

	public String getTransaction_password() {
		return transaction_password;
	}

	public void setTransaction_password(String transaction_password) {
		this.transaction_password = transaction_password;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSecurity_questions() {
		return security_questions;
	}

	public void setSecurity_questions(String security_questions) {
		this.security_questions = security_questions;
	}

	public String getSecurity_answers() {
		return security_answers;
	}

	public void setSecurity_answers(String security_answers) {
		this.security_answers = security_answers;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	@Override
	public String toString() {
		return "InternetBankingUser [user_id=" + user_id + ", login_password=" + login_password
				+ ", transaction_password=" + transaction_password + ", attempts=" + attempts + ", status=" + status
				+ ", security_questions=" + security_questions + ", security_answers=" + security_answers
				+ ", account_number=" + account_number + "]";
	}

}
