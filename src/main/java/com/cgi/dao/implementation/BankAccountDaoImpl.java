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
	
	/**
	 * method that allows  to make a deposit of money 
	 * @param amount
	 * @param account
	 **/
	public double deposit(double amount, BankAccount account) {
		
		if(amount <= 0) {
			throw new IllegalArgumentException("The amount must be greater than zero");
		
		}else {
			
			account.setBalance(account.getBalance() + amount);	
			recordOperation(account.getAccountNumber(), "Deposit", new Date(), amount, account.getBalance());			
		}
		
		return account.getBalance();
	}
	
	/**
	 * method that allows to withdraw an amount of money  
	 * @param amount
	 * @param account
	 **/
	public double withdraw(double amount, BankAccount account) {
		if(amount <= 0) {
			throw new IllegalArgumentException("The amount must be greater than zero");
		
		}else {
	
			if(amount > account.getBalance()) 
				throw new IllegalArgumentException("The amount is greater than the balance");
				
			if(amount <= account.getBalance()) {
				account.setBalance(account.getBalance() - amount);
				recordOperation(account.getAccountNumber(), "Withdraw", new Date(), amount, account.getBalance());
			}
			
		}
		return account.getBalance();
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
	private void recordOperation(String accountNumber, String operation, Date date, double amount, double balance) {
		
		
		PrintingStatement statement = new PrintingStatement();	
		statement.setAccountNumber(accountNumber);
		statement.setAmount(amount);
		statement.setBalance(balance);
		statement.setDate(date);
		statement.setOperation(operation);
	}
	
	/**
	 * method that allows to check the operations of a customer
	 * @param accountNumber
	 * @param statements
	 **/
	public void checkOperation(String accountNumber, List<PrintingStatement> statements) {
		
		for (int i = 0; i < statements.size(); i++) {
	        if (statements.get(i).getAccountNumber().equals(accountNumber)) {
	            System.out.println(statements.get(i).getOperation() + "//" + statements.get(i).getAmount() + "//" + statements.get(i).getBalance() + "//" + statements.get(i).getDate());
	            System.out.println("\n");
	        }
	    }
	}
}
