package com.cgi.dao.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cgi.dao.BankAccountDao;
import com.cgi.model.BankAccount;
import com.cgi.model.PrintingStatement;


public class BankAccountDaoImpl implements BankAccountDao  {
	
	private List<PrintingStatement> statements = new ArrayList<PrintingStatement>();
	/**
	 * method that allows  to make a deposit of money 
	 * @param amount
	 * @param accountNumber
	 * @param bankAccounts represents all bank accounts
	 **/
	public double deposit(double amount, String accountNumber, Map<String, BankAccount> bankAccounts) {
		
		if(amount <= 0) {
			throw new IllegalArgumentException("The amount must be greater than zero");
		
		}else {
			for(BankAccount account : bankAccounts.values()) {
				if(account.getAccountNumber().equals(accountNumber)) {
					account.setBalance(account.getBalance() + amount);	
				    recordOperation(accountNumber, "Deposit", new Date(), amount, account.getBalance(), statements);
				    	
				} 
			}
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
		if(amount <= 0) {
			throw new IllegalArgumentException("The amount must be greater than zero");
		
		}else {
			for(BankAccount account : bankAccounts.values()) {
				
				if(account.getAccountNumber().equals(accountNumber) && amount > account.getBalance()) 
					throw new IllegalArgumentException("The amount is greater than the balance");
				
				if(account.getAccountNumber().equals(accountNumber) && amount <= account.getBalance()) {
					account.setBalance(account.getBalance() - amount);
					recordOperation(accountNumber, "Withdraw", new Date(), amount, account.getBalance(), statements);
				}
			}
		}
		return bankAccounts.get(accountNumber).getBalance();
	}
	
	/**
	 * method that allows to record the operation of a customar
	 * @param accountNumber
	 * @param operation
	 * @param date 
	 * @param amount
	 * @param balance
	 * @param statements
	 **/
	private void recordOperation(String accountNumber, String operation, Date date, double amount, double balance, List<PrintingStatement> statements) {
		
		
		statements.add(new PrintingStatement(operation, date, amount, balance, accountNumber));		
	}
	
	/**
	 * method that allows to check the operations of a customer
	 * @param accountNumber
	 **/
	public void checkOperation(String accountNumber) {
		
		for (int i = 0; i < statements.size(); i++) {
	        if (statements.get(i).getAccountNumber().equals(accountNumber)) {
	            System.out.println(statements.get(i).getOperation() + "//" + statements.get(i).getAmount() + "//" + statements.get(i).getBalance() + "//" + statements.get(i).getDate());
	            System.out.println("\n");
	        }
	    }
	}
}
