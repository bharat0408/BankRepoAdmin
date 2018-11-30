package com.bank.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.AccountDao;
import com.bank.dao.IReportGeneration;
import com.bank.model.Account;
import com.bank.model.Address;
import com.bank.model.Customer;
import com.bank.model.InternetBankingUser;
import com.bank.model.Login;
import com.bank.model.Payee;
import com.bank.model.Transaction;

@Service
public class ReportGenerationService implements IReportGenerationService{

	@Autowired
	ReportGenerationService rdao;

	@Transactional

	public List<Transaction> getAccountStatement(Date from, Date to) {
		// TODO Auto-generated method stub
		return rdao.getAccountStatement(from, to);
	}

	@Override
	public void generateReport() {
		
		
	}



}