package com.bank.controller;
import java.util.logging.*;
import java.io.IOException;
import java.rmi.ServerException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.dao.AccountDao;
import com.bank.dao.IReportGeneration;
import com.bank.model.Account;
import com.bank.model.AccountNumber;
import com.bank.model.Address;
import com.bank.model.Customer;
import com.bank.model.InternetBankingUser;
import com.bank.model.Login;
import com.bank.model.Payee;
import com.bank.model.Profile;
import com.bank.model.Transaction;
import com.bank.service.IAccountService;
import com.bank.service.IFundTransferService;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class BankController {
	@Autowired
	private IAccountService accountService;

	@Autowired
	private IFundTransferService fundTransferService;

	@Autowired
	private IReportGeneration reportGenerationService;

	@RequestMapping(value="/open",method = RequestMethod.POST)
	public ModelAndView openAccount(ModelAndView model, @ModelAttribute Customer customer, Account account,
			Address address) {

		//System.out.println("inside open acc controller");
	//	System.out.println(customer.getCustomer_id());
		
		
	//	account.setCustomer_id(customer.getCustomer_id());

		long accountNum = accountService.openAccount(customer, account, address);

		if (accountNum > 0) {
			model.setViewName("AccountInformation");
			
			model.addObject("user_account_number",accountNum);
			
			model.addObject("notification","Account created successfully");
		} else {
			model.addObject("notification", "Could not create your account");
			model.setViewName("OpenAccount");
		}

		return model;

	}

	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ModelAndView register(ModelAndView model, @ModelAttribute InternetBankingUser ibu) {

		
		

		// REGISTER IF IT EXISTS
		int i = accountService.registerOnline(ibu);

		if (i > 0) {

			model.setViewName("Login");

		} else
			model.setViewName("Register");

		return model;

	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView model, @ModelAttribute Login login, HttpSession session) {

		if (accountService.validateUser(login)) {

			long accountNumber = accountService.getAccountNumber(login);

			session.setAttribute("account_number", accountNumber);

			model.setViewName("Dashboard");

		} else {
			
			model.setViewName("Login");

		}

		return model;

	}

	@RequestMapping("/addPayee")
	public ModelAndView addPayee(ModelAndView model, @ModelAttribute Payee payee, HttpSession session) {

		System.out.println(payee);
		payee.setCustomer_account_number((Long) session.getAttribute("account_number"));

		int i = fundTransferService.addPayee(payee);

		if (i > 0)
		{
			model.addObject("payee_status", "Payee added successfully");

			model.setViewName("Dashboard");
		}
		else
			model.setViewName("Payee");

		return model;

	}

	@RequestMapping("/DeletePayee")
	public ModelAndView deletePayee(HttpServletRequest request, HttpServletResponse response, ModelAndView model,
			HttpSession session) {

		System.out.println("in controller " + session.getAttribute("account_number"));

		int i = fundTransferService.deletePayee(request.getParameter("payee_name"),
				(Long) session.getAttribute("account_number"));

		if (i > 0) {
			model.addObject("payee_status", "Payee Deleted Successfully");
			
			

			model.setViewName("Dashboard");
		} else {
			model.addObject("payee_status", "Does not exist");
			model.setViewName("Dashboard");
		}

		return model;

	}

	@RequestMapping("/DisplayPayee")
	public ModelAndView displayPayee(HttpServletRequest request, HttpServletResponse response, ModelAndView model,
			HttpSession session) {


		List<Payee> payeeList = fundTransferService.displayPayee((Long) session.getAttribute("account_number"));

		model.addObject("PayeeList", payeeList);
		model.setViewName("Dashboard");

		return model;

	}

	@RequestMapping("/FundTransfer")
	public ModelAndView fundTransfer(HttpServletRequest request, HttpServletResponse response, ModelAndView model,
			HttpSession session) {


		List<Payee> payeeList = fundTransferService.displayPayee((Long) session.getAttribute("account_number"));

		System.out.println(payeeList.size());
		
		model.addObject("PayeeList", payeeList);

		model.setViewName("FundTransferForm");

		return model;

	}

	@RequestMapping("/ConfirmPayment")
	public ModelAndView confirmTransaction(HttpServletRequest request, HttpServletResponse response, ModelAndView model,
			HttpSession session, @ModelAttribute Transaction tr) {




		boolean isSuccessful = fundTransferService.confirmTransaction(tr,
				(Long) session.getAttribute("account_number"));

		if (isSuccessful) {
			model.addObject("transaction","Fund Transfer Successful");
			model.setViewName("Dashboard");
			
		} else {
	       model.addObject("transaction","Transaction Failure");

			model.setViewName("Dashboard");
		}


		return model;

	}
	
	
	
	
	@RequestMapping("/summary")
	public ModelAndView accountSummary(ModelAndView model, HttpSession session) {
		// float balance = accountService.getBalance((Long) session.getAttribute("account_number"));
		
         Account userAccount = accountService.getSummary((Long) session.getAttribute("account_number"));
		
		// model.addObject("balance", balance);
    
         
         model.addObject("summary", userAccount);
         
         
         
         model.setViewName("AccountSummary");
       



		return model;

	}

	@RequestMapping("/AccountStatement")
	public ModelAndView getAccountStatement(HttpServletRequest request, HttpServletResponse response,
			ModelAndView model, HttpSession session) {


		String fromDate = request.getParameter("from");
		String toDate = request.getParameter("to");

		SimpleDateFormat current = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat requiredFormat = new SimpleDateFormat("dd-MMM-yy");
		Date from = null;
		Date to = null;
		try {
			from = current.parse(fromDate);
			to = current.parse(toDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fromDate = requiredFormat.format(from);
		toDate = requiredFormat.format(to);

		List<Transaction> accountStatement = reportGenerationService.getAccountStatement(fromDate, toDate,
				(Long) session.getAttribute("account_number"));

		if(accountStatement.size()!=0) {
		model.addObject("AccountStatementList", accountStatement);
        
		}
		else
		{ 
			model.addObject("statement","No Results Found");
		
		}
		model.setViewName("AccountStatement");

		return model;

	}
	
	
	@RequestMapping("/details")
	public ModelAndView accountDetails(ModelAndView model, HttpSession session) {
		// float balance = accountService.getBalance((Long) session.getAttribute("account_number"));
		
     //    Account userAccount = accountService.getSummary((Long) session.getAttribute("account_number"));
		
		// model.addObject("balance", balance);
    
         
   //      model.addObject("summary", userAccount);
		
		
         Profile userProfile = accountService.getDetails((Long) session.getAttribute("account_number"));
         
         model.addObject("user_profile",userProfile);
         
         System.out.println(userProfile);
         
         model.setViewName("AccountDetails");
       



		return model;

	}

}
