package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bank.model.Payee;
import com.bank.model.Transaction;
import com.bank.service.IFundTransferService;

public class FundTransferDao implements IFundTransferDao {

	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addPayee(Payee payee) {
		int i = 0;

		System.out.println("hows u");
		System.out.println(payee.getCustomer_account_number());

		String addPayeeQuery = "insert into GR13_payee values(" + payee.getPayee_account_number() + ",'"
				+ payee.getName() + "','" + payee.getNick_name() + "'," + payee.getCustomer_account_number() + ")";
		i = jdbcTemplate.update(addPayeeQuery);

		return i;
	}

	public int deletePayee(String name, long customerAccountNumber) {
		int i = 0;

		String deletePayeeQuery = "delete from gr13_payee where gp_name='" + name
				+ "' and GP_GC_CUSTOMER_ACCOUNT_NUMBER=" + customerAccountNumber;
		i = jdbcTemplate.update(deletePayeeQuery);

		return i;
	}

	public List<Payee> displayPayee(long accountNumber) {
		// TODO Auto-generated method stub

		String getPayeeQuery = "select * from gr13_payee where GP_GC_CUSTOMER_ACCOUNT_NUMBER=" + accountNumber;

		return jdbcTemplate.query(getPayeeQuery, new RowMapper<Payee>() {
			public Payee mapRow(ResultSet rs, int rownumber) throws SQLException {
				Payee payee = new Payee();
				payee.setPayee_account_number(rs.getLong(1));
				payee.setName(rs.getString(2));
				payee.setNick_name(rs.getString(3));

				return payee;
			}
		});
	}

	public synchronized boolean confirmTransaction(Transaction tr) {
		// TODO Auto-generated method stub

		int i = 0, j = 0, k = 0;
		System.out.println(tr);
		// String getPayeeQuery="select * from gr13_payee where
		// GP_GC_CUSTOMER_ACCOUNT_NUMBER="+tr.getFrom_account();

		// UPDATE BALANCE OF CUSTOMER AND PAYEE
		String updateCustomerBalance = "update gr13_accounts set ga_balance=ga_balance-"
				+ (tr.getAmount() + tr.getCharges()) + " where ga_account_number=" + tr.getFrom_account();
		i = jdbcTemplate.update(updateCustomerBalance);

		String updatePayeeBalance = "update gr13_accounts set ga_balance=ga_balance+" + tr.getAmount()
		+ " where ga_account_number=" + tr.getTo_account();
		j = jdbcTemplate.update(updatePayeeBalance);

		if (i > 0 && j <= 0) {
			updateCustomerBalance = "update gr13_accounts set ga_balance=ga_balance+"
					+ (tr.getAmount() + tr.getCharges()) + " where ga_account_number=" + tr.getFrom_account();
			i = jdbcTemplate.update(updateCustomerBalance);

			// DEDUCTED FROM CUSTOMER BUT NOT ADDED TO PAYEE
			return false;
		} else if (j > 0 && i <= 0) {
			// ADDED TO PAYEE BUT NOT DEDUCTED FROM CUSTOMER
			updateCustomerBalance = "update gr13_accounts set ga_balance=ga_balance-" + tr.getAmount()
			+ " where ga_account_number=" + tr.getTo_account();
			i = jdbcTemplate.update(updateCustomerBalance);

			return false;
		} else if (j <= 0 && i <= 0) {
			// NOT DEDUCTED AND NOT ADDED

			return false;
		}

		else if (i > 0 && j > 0) {
			// BOTH THE TABLES UPDATED SUCCESSFULLY
			// UPDATE TRANSACTION TABLE
			String insertTransactionQuery = "insert into gr13_transactions values (" + tr.getReference_id() + ",'"
					+ tr.getType() + "'," + tr.getAmount() + "," + tr.getFrom_account() + "," + tr.getTo_account()
					+ ",CURRENT_TIMESTAMP,'" + tr.getRemark() + "'," + tr.getCharges() + ")";
			k = jdbcTemplate.update(insertTransactionQuery);

		}

		if (k > 0)
			return true;

		else {
			// IF TRANSACTION IS NOT SAVED, CREDIT TO CUSTOMER AND
			updateCustomerBalance = "update gr13_accounts set ga_balance=ga_balance+"
					+ (tr.getAmount() + tr.getCharges()) + " where ga_account_number=" + tr.getFrom_account();
			i = jdbcTemplate.update(updateCustomerBalance);

			updateCustomerBalance = "update gr13_accounts set ga_balance=ga_balance-" + tr.getAmount()
			+ " where ga_account_number=" + tr.getTo_account();
			i = jdbcTemplate.update(updateCustomerBalance);

		}

		return false;
	}

	public long payeeAccountNumber(Transaction tr, long accountNumber) {

		System.out.println(tr.getPayee_name() + " inside dao");
		// TODO Auto-generated method stub
		String getPayeeQuery = "select GP_PAYEE_ACCOUNT_NUMBER from gr13_payee where GP_GC_CUSTOMER_ACCOUNT_NUMBER="
				+ accountNumber + " and gp_name='" + tr.getPayee_name() + "'";

		long payeeAccountNumber = jdbcTemplate.queryForObject(getPayeeQuery, Long.class);

		System.out.println("inside fund transfer dao " + payeeAccountNumber);

		return payeeAccountNumber;
	}

}
