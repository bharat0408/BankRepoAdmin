package com.bank.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Account;
import com.bank.model.Address;
import com.bank.model.Customer;
import com.bank.model.InternetBankingUser;
import com.bank.model.Login;
import com.bank.model.Payee;
import com.bank.model.Profile;

public interface IAccountService {

	public long openAccount(Customer customer, Account account, Address address);

	public int registerOnline(InternetBankingUser ibu);

	public boolean validateUser(Login login);

	public long getAccountNumber(Login login);
	
	public float getBalance(long accountNumber);
	
	public Account getSummary(long accountNumber);
	

	public Profile getDetails(long customerAccountNumber) ;


}