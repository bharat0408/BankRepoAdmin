package com.bank.service;

import java.util.Date;
import java.util.List;

import com.bank.model.Transaction;

public interface IReportGenerationService {
	public List<Transaction> getAccountStatement(Date from, Date to);
	
	public void generateReport();
}
