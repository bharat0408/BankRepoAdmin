package com.bank.dao;

import java.util.List;

import com.bank.model.Payee;
import com.bank.model.Transaction;

public interface IFundTransferDao {
	public int addPayee(Payee payee);

	public int deletePayee(String name, long customerAccountNumber);

	public List<Payee> displayPayee(long accountNumber);

	public boolean confirmTransaction(Transaction tr);

	public long payeeAccountNumber(Transaction tr, long accountNumber);
	

}
