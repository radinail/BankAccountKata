package com.cgi.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cgi.model.BankAccount;
import com.cgi.model.PrintingStatement;

public interface BankAccountDao {
	
	/**
	 * method that allows  to make a deposit of money 
	 * @param amount
	 * @param account
	 **/
	public double deposit(double amount, BankAccount account);
	
	/**
	 * method that allows to withdraw an amount of money 
	 * @param amount
	 * @param account
	 **/
	public double withdraw(double amount, BankAccount account);
	

	/**
	 * method that allows to check the operations of a customer
	 * @param accountNumber
	 * @param account
	 **/
	public void checkOperation(String accountNumber, List<PrintingStatement> statements);



}
