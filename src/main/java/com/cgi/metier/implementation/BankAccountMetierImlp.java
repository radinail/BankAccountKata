package com.cgi.metier.implementation;

import java.util.List;
import java.util.Map;

import com.cgi.dao.BankAccountDao;
import com.cgi.metier.BankAccountMetier;
import com.cgi.model.BankAccount;
import com.cgi.model.PrintingStatement;


public class BankAccountMetierImlp implements BankAccountMetier {
	
	/** bank account dao*/
	private BankAccountDao bankAccountDao;
	
	/**
	 * method that allows  to make a deposit of money 
	 * @param amount
	 * @param account
	 **/
	public double deposit(double amount, BankAccount account) {
		try {
			
			double balance = bankAccountDao.deposit(amount, account);
			 
		    account.setBalance(balance);
			
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		return account.getBalance();
	}
	
	/**
	 * method that allows to withdraw an amount of money 
	 * @param amount
	 * @param account
	 **/
	public double withdraw(double amount, BankAccount account) {
	    try {
			
			double balance = bankAccountDao.withdraw(amount, account);
			
			account.setBalance(balance);
			
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	    return account.getBalance();
	} 
	
	/**
	 * method that allows to check the operations of a customer
	 * @param accountNumber
	 * @param statements
	 **/
	public void checkOperation(String accountNumber, List<PrintingStatement> statements) {
		
		bankAccountDao.checkOperation(accountNumber, statements);
	}
	
	/**
     * set bankAccountDao
     * @param bankAccountDao
     */public void setBankAccountDao(BankAccountDao bankAccountDao) {
		this.bankAccountDao = bankAccountDao;
	}
     
	
	
}
