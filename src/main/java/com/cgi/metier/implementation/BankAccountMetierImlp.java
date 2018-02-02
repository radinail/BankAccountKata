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
	 * @param accountNumber
	 * @param bankAccounts represents all bank accounts
	 **/
	public double deposit(double amount, String accountNumber, Map<String, BankAccount> bankAccounts) {
		try {
			
			double balance = bankAccountDao.deposit(amount, accountNumber, bankAccounts);
			 
			bankAccounts.get(accountNumber).setBalance(balance);
			
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		return bankAccounts.get(accountNumber).getBalance();
	}
	
	/**
	 * method that allows to withdraw an amount of money 
	 * @param amount
	 * @param accountNumber
	 * @param bankAccounts represents all bank accounts
	 **/
	public double withdraw(double amount, String accountNumber, Map<String, BankAccount> bankAccounts) {
	    try {
			
			double balance = bankAccountDao.withdraw(amount, accountNumber, bankAccounts);
			
			bankAccounts.get(accountNumber).setBalance(balance);
			
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	    return bankAccounts.get(accountNumber).getBalance();
	} 
	
	/**
	 * method that allows to check the operations of a customer
	 * @param accountNumber
	 **/
	public void checkOperation(String accountNumber) {
		
		bankAccountDao.checkOperation(accountNumber);
	}
	
	/**
     * set bankAccountDao
     * @param bankAccountDao
     */public void setBankAccountDao(BankAccountDao bankAccountDao) {
		this.bankAccountDao = bankAccountDao;
	}
     
	
	
}
