package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bank.model.Account;
import com.bank.model.Address;
import com.bank.model.Customer;

public class AdminDao {

	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public long openAccount(Customer customer, Account account, Address address)
	{
		int i=0;
		
		String getCustomerId= "select GR13_customers_seq.nextval from dual";
		long customerId = getCustomerSeq(getCustomerId);

		String getAccountNumber= "select GR13_accounts_seq.nextval from dual";
		long accountNumber = getCustomerSeq(getAccountNumber);

		String getAddressId= "select GR13_addresses_seq.nextval from dual";
		long addressId = getCustomerSeq(getAddressId);

		String customerTableQuery="insert into GR13_ADMIN_CUSTOMERS values("+customerId+",'"+customer.getFirst_name()+"','"+customer.getMiddle_name()+"','"+customer.getLast_name()+"','"+customer.getFather_name()+"','"+customer.getEmail_id()+"',"+customer.getMobile_number()+","+customer.getAadhar_card()+",'"+customer.getDate_of_birth()+"',"+customer.getAnnual_income()+")";

		//ADD ALL THE CONDITIONS

		i= jdbcTemplate.update(customerTableQuery);

		String accountTableQuery="insert into GR13_ADMIN_ACCOUNTS values("+accountNumber+",500000,'SAVINGS',"+customerId+")";

		i =  jdbcTemplate.update(accountTableQuery);

		String addressTableQuery="insert into  GR13_ADMIN_ADDRESSES values("+addressId+",'"+address.getAddress_line_1()+"','"+address.getAddress_line_2()+"',"+address.getPin_code()+",'"+address.getCity()+"','"+address.getState()+"',"+customerId+")";

		i =  jdbcTemplate.update(addressTableQuery);
		
		if(i<=0)
		{
			//accountNumber=0;
			return 0;
		}
		return accountNumber;
	}


	public List<AdminModel> getAllInfo(AdminModel am){  
		 String sql="select * from gr13_Admin"; 
		 return jdbcTemplate.query(sql, new RowMapper<AdminModel>(){  
			 public AdminModel mapRow(ResultSet rs, int rownumber) throws SQLException {  
	AdminModel a = new AdminModel();  
	a.setId(rs.getString(1));
	a.setName(rs.getString(2));
	  return a;  
	
	 }
		 });
	}

	/*
public int deleteData(String id) {
	String query= "delete from gr13_Admin where id =?";
	return jdbcTemplate.update(query, new Object[] {id});
}



public int saveData1(String id) {
	String query = "insert into G13_Account ("+customerId+",'"+customer.getFirst_name()+"','"+customer.getMiddle_name()+"','"+customer.getLast_name()+"','"+customer.getFather_name()+"','"+customer.getEmail_id()+"',"+customer.getMobile_number()+","+customer.getAadhar_card()+",'"+customer.getDate_of_birth()+"',"+customer.getAnnual_income()+")"; select id,name from gr13_Admin where id=?"; 
	return jdbcTemplate.update(query,new Object[] {id});
}
*/
public long getCustomerSeq(String query) {

	long res = jdbcTemplate.queryForObject(query, Long.class);
	return res;
}
}
