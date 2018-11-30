package com.bank.dao;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessException.*; 
import org.springframework.jdbc.core.ResultSetExtractor;import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.servlet.ModelAndView;

import com.bank.model.Account;
import com.bank.model.AccountNumber;
import com.bank.model.Address;
import com.bank.model.Customer;
import com.bank.model.InternetBankingUser;
import com.bank.model.Login;
import com.bank.model.Payee;
import com.bank.model.Profile;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.activation.*;


public class AccountDao implements IAccountDao
{
	JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public long createAccount(Customer customer, Account account, Address address)
	{
		int i=0,j=0,k=0;

		String getCustomerId= "select GR13_customers_seq.nextval from dual";
		long customerId = getCustomerSeq(getCustomerId);

		String getAccountNumber= "select GR13_accounts_seq.nextval from dual";
		long accountNumber = getCustomerSeq(getAccountNumber);

		String getAddressId= "select GR13_addresses_seq.nextval from dual";
		long addressId = getCustomerSeq(getAddressId);

		String customerTableQuery="insert into GR13_customers values("+customerId+",'"+customer.getFirst_name()+"','"+customer.getMiddle_name()+"','"+customer.getLast_name()+"','"+customer.getFather_name()+"','"+customer.getEmail_id()+"',"+customer.getMobile_number()+","+customer.getAadhar_card()+",'"+customer.getDate_of_birth()+"',"+customer.getAnnual_income()+")";

		//ADD ALL THE CONDITIONS

		i= jdbcTemplate.update(customerTableQuery);

		String accountTableQuery="insert into GR13_accounts values("+accountNumber+",500000,'SAVINGS',"+customerId+")";

		i =  jdbcTemplate.update(accountTableQuery);

		String addressTableQuery="insert into GR13_addresses values("+addressId+",'"+address.getAddress_line_1()+"','"+address.getAddress_line_2()+"',"+address.getPin_code()+",'"+address.getCity()+"','"+address.getState()+"',"+customerId+")";

		//	String query="insert into customers values('"+rf.getUserId()+"','"+rf.getMobileNo()+"','"+rf.getAmount()+"','"+rf.getOperator()+"')";

		i =  jdbcTemplate.update(addressTableQuery);

		if(i<=0)
		{
			//accountNumber=0;
			return 0;
		}
		return accountNumber;
	}

	//search account number before this

	public int register(InternetBankingUser ibu)
	{
		int i =0;


		
//	   String register="insert into GR13_internet_banking_users values(?,?,?,?,?,?,?,?)";
				
		
		i= jdbcTemplate.update("insert into GR13_internet_banking_users values(?,?,?,?,?,?,?,?)", new Object[] {ibu.getUser_id(), ibu.getLogin_password(), ibu.getTransaction_password(),0,"enabled", ibu.getSecurity_questions(), ibu.getSecurity_answers(), ibu.getAccount_number()});		
		
		

	/*	String register="insert into GR13_internet_banking_users values('"+ibu.getUser_id()+"','"+ibu.getLogin_password()+"','"+ibu.getTransaction_password()+"',0,'enabled','"+ibu.getSecurity_questions()+"','"+ibu.getSecurity_answers()+"',"+ibu.getAccount_number()+")";
		
		
		
		
		i= jdbcTemplate.update(register);		*/


		return i;

	}


	public boolean login(Login login)
	{


		String validateUserQuery = "select * from GR13_internet_banking_users where GIBU_USER_ID='" + login.getUser_id() + "' and GIBU_LOGIN_PASSWORD='" + login.getPassword() +"'";
		List<InternetBankingUser> users = jdbcTemplate.query(validateUserQuery, new UserMapper());
		
		
		
		
		return users.size() > 0 ? true : false;



	}


	public long getAccountNumber(Login login) {
		// TODO Auto-generated method stub



		String getAccountNumberQuery="select GIBU_GA_ACCOUNT_NUMBER from gr13_internet_banking_users where gibu_user_id='"+login.getUser_id()+"'"; 

		long accountNumber =jdbcTemplate.queryForObject(getAccountNumberQuery, Long.class); 	 

		return accountNumber;


	}



	public long getCustomerSeq(String query) {

		long res = jdbcTemplate.queryForObject(query, Long.class);
		return res;
	}


	class UserMapper implements RowMapper<InternetBankingUser> {
		public InternetBankingUser mapRow(ResultSet rs, int arg1) throws SQLException {
			InternetBankingUser user = new InternetBankingUser();
		

			user.setUser_id(rs.getString(1));
			user.setLogin_password(rs.getString(2));


			return user;
		}

	}

	public float checkBalance(long customerAccountNumber){  
		//System.out.println("inside dao"+rf.getUserId());
		String getBalanceQuery="select ga_balance from gr13_accounts where ga_account_number="+customerAccountNumber; 



		float balance = jdbcTemplate.queryForObject(getBalanceQuery, Float.class); 	 

		return balance;
	}
	
	


	public  void emailAccountNumber(Customer customer, Account account, Address address)
	{
		String to = customer.getEmail_id();
		System.out.println(to);

		// Sender's email ID needs to be mentioned
		String from = "isaac.m@somaiya.edu";

		// Assuming you are sending email from localhost
		String host = "localhost";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", "8082");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("Your Account is Activated!");

			// Send the actual HTML message, as big as you like
			message.setContent("<h1>Your Account Number is "+account.getAccount_number()+"</h1>", "text/html");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	@Override
	public Account getSummary(long customerAccountNumber) {
		// TODO Auto-generated method stub
		
		String getSummaryQuery="select * from gr13_accounts where ga_account_number="+customerAccountNumber; 



		Account userAccount = jdbcTemplate.queryForObject(getSummaryQuery, new AccountMapper()); 	 
		
		
		return userAccount;
	}
	
	
	class AccountMapper implements RowMapper<Account> {
		public Account mapRow(ResultSet rs, int arg1) throws SQLException {
			Account user = new Account();
		
			user.setCustomer_id(rs.getLong(4));
			user.setAccount_number(rs.getLong(1));
			user.setBalance(rs.getFloat(2));
            user.setAccount_type(rs.getString(3));


			return user;
		}

	}
	
	class ProfileMapper implements RowMapper<Profile> {
		public Profile mapRow(ResultSet rs, int arg1) throws SQLException {
			Profile user = new Profile();
		
			user.setCustomer_id(rs.getInt(1));
			user.setFirst_name(rs.getString(2));
			user.setMiddle_name(rs.getString(3));
			user.setLast_name(rs.getString(4));
			user.setFather_name(rs.getString(5));
			user.setEmail_id(rs.getString(6));
			user.setMobile_number(rs.getLong(7));
			user.setAadhar_card(rs.getLong(8));
			user.setDate_of_birth(rs.getString(9));
			user.setAnnual_income(rs.getInt(10));
			user.setAddress_line_1(rs.getString(12));
			user.setAddress_line_2(rs.getString(13));
			user.setPin_code(rs.getString(14));
			user.setCity(rs.getString(15));
			user.setState(rs.getString(16));
			user.setAccount_number(rs.getLong(18));
			user.setAccount_type(rs.getString(20));
			user.setBalance(rs.getFloat(19));



			return user;
		}

	}

	public Profile getProfileDetails(long customerAccountNumber) {
		// TODO Auto-generated method stub
		
		Profile userDetails = new Profile();
		
		String getProfileQuery="select * from gr13_customers c, gr13_addresses ad, gr13_accounts ac  where c.gc_customer_id = ad.gt_gc_customer_id  and c.gc_customer_id = ac.ga_gc_customer_id and GA_ACCOUNT_NUMBER="+customerAccountNumber; 

		
		userDetails = jdbcTemplate.queryForObject(getProfileQuery, new ProfileMapper()); 	 

		
		
		
		return userDetails;
	}
	

}  

