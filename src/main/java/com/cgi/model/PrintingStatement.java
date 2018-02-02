package com.cgi.model;

import java.util.Date;

public class PrintingStatement {
	
	/** type of operation*/
	private String operation;
	
	/** the date on which the operation was performed*/
	private Date date;
	
	/** the amount of the operation*/
	private double amount;
	
	/** the balance*/
	private double balance;
	
	/** the account number*/
	private String accountNumber;
	
	/** the constructor*/
	public PrintingStatement(String operation, Date date, double amount, double balance, String accountNumber) {
		super();
		this.operation = operation;
		this.date = date;
		this.amount = amount;
		this.balance = balance;
		this.accountNumber = accountNumber;
	}
	
	/** get operation
	 * @return operation 
	 **/
	public String getOperation() {
		return operation;
	}
	
	/** set operation
	 * @param operation 
	 **/
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	/** get date
	 * @return operation 
	 **/
	public Date getDate() {
		return date;
	}
	
	/** set date
	 * @param date 
	 **/
	public void setDate(Date date) {
		this.date = date;
	}
	
	/** get amount
	 * @return amount 
	 **/
	public double getAmount() {
		return amount;
	}
	
	/** set amount
	 * @param amount 
	 **/
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	/** get balance
	 * @return balance 
	 **/
	public double getBalance() {
		return balance;
	}
	
	/** set balance
	 * @param balance 
	 **/
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	/** get account number
	 * @return accountNumber  
	 **/
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/** set account number
	 * @param accountNumber  
	 **/
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
	
}
