package com.bank.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.AccountDao;
import com.bank.dao.FundTransferDao;
import com.bank.model.Payee;
import com.bank.model.Transaction;

@Service
public class FundTransferService implements IFundTransferService {
	@Autowired
	FundTransferDao tdao;

	@Autowired
	AccountDao edao;

	@Transactional
	public int addPayee(Payee payee) {
		System.out.println("yo");
		// TODO Auto-generated method stub
		System.out.println(payee.getCustomer_account_number() + "in ser");
		return tdao.addPayee(payee);
	}

	public int deletePayee(String name, long customerAccountNumber) {
		return tdao.deletePayee(name, customerAccountNumber);
	}

	public List<Payee> displayPayee(long accountNumber) {
		// TODO Auto-generated method stub
		return tdao.displayPayee(accountNumber);
	}

	public synchronized boolean confirmTransaction(Transaction tr, long userAccountNumber) {

		// FINDING TRANSACTION CHARGES
		float charges = calculateCharges(tr);
		tr.setCharges(charges);

		// CHECKING BALANCE
		float balance = edao.checkBalance(userAccountNumber);

		if (balance < (tr.getAmount() + charges)) {
			return false;
		}

		// GENERATING REFERENCE ID
		long referenceId = generateRandom(12);
		tr.setReference_id(referenceId);

		// FINDING PAYEE ACCOUNT NUMBER
		long accountNumber = tdao.payeeAccountNumber(tr, userAccountNumber);
		tr.setTo_account(accountNumber);
		
		//FINDING PAYEE NAME
		
		

		tr.setFrom_account(userAccountNumber);

		return tdao.confirmTransaction(tr);
	}

	public static long generateRandom(int length) {
		Random random = new Random();
		char[] digits = new char[length];
		digits[0] = (char) (random.nextInt(9) + '1');
		for (int i = 1; i < length; i++) {
			digits[i] = (char) (random.nextInt(10) + '0');
		}
		return Long.parseLong(new String(digits));
	}

	public static float calculateCharges(Transaction tr) {
		float charges = 0.0f;
		long amount = tr.getAmount();

		if (tr.getType().equals("IMPS")) {
			if (amount < 100000) {
				charges = 5 + 18 / 100 * 5;

			} else if (amount > 100000 && amount < 200000) {
				charges = 15 + 18 / 100 * 15;
			}
		}

		else if (tr.getType().equals("RTGS")) {
			if (amount < 500000 && amount > 200000) {
				charges = 25 + 18 / 100 * 25;

			} else if (amount > 500000) {
				charges = 50 + 18 / 100 * 50;
			}
		}

		return charges;
	}

	public boolean confirmTransaction(Transaction tr, Long accountNumber) {
		// TODO Auto-generated method stub

		return false;
	}

	public List<Transaction> getAccountStatement(java.sql.Date from, java.sql.Date to) {
		// TODO Auto-generated method stub
		return null;
	}

}
