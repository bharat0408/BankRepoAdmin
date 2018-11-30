package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bank.model.*;

public class ReportGeneration implements IReportGeneration {

	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	class TransactionMapper implements RowMapper<Transaction> {
		public Transaction mapRow(ResultSet rs, int arg1) throws SQLException {
			Transaction transaction = new Transaction();

			transaction.setReference_id(rs.getLong(1));
			transaction.setType(rs.getString(2));
			transaction.setAmount(rs.getInt(3));
			transaction.setFrom_account(rs.getLong(4));
			transaction.setTo_account(rs.getLong(5));
			transaction.setTimestamp(rs.getDate(6));
			transaction.setRemark(rs.getString(7));
			transaction.setCharges(rs.getFloat(8));
			
			

			return transaction;
		}

	}

	public List<Transaction> getAccountStatement(String startDate, String endDate, long accountNumber) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");

		String getStatementFromQuery = "select * from gr13_transactions where gt_timestamp >= '" + startDate
				+ "' and gt_timestamp<='" + endDate + "' and gt_ga_from_account=" + accountNumber;

		List<Transaction> transactionList1 = (List<Transaction>) jdbcTemplate.query(getStatementFromQuery,
				new TransactionMapper());
		
		transactionList1.stream().forEach(debit -> debit.setStatus("Debit"));

		
		String getStatementToQuery = "select * from gr13_transactions where gt_timestamp >= '" + startDate
				+ "' and gt_timestamp<='" + endDate + "' and GT_TO_ACCOUNT=" + accountNumber;
		
		List<Transaction> transactionList2 = (List<Transaction>) jdbcTemplate.query(getStatementToQuery,
				new TransactionMapper());
		
		transactionList2.stream().forEach(credit -> credit.setStatus("Credit"));
		transactionList2.stream().forEach(credit -> credit.setCharges(0));

		


		
		List<Transaction> transactionList = new ArrayList<Transaction>(transactionList1);
		transactionList.addAll(transactionList2);
		
		
     
		transactionList.sort(Comparator.comparing(o -> ((Transaction) o).getTimestamp()).reversed());
	//	Collections.sort(transactionList, (p1, p2) -> p1.getTimestamp() - p2.getTimestamp());

	
		return transactionList;

	}
	
	
		

}