package com.cgi.model;

public class BankAccount {
        
        /** customar Name */
        private String name;
        /** account number*/
        private String accountNumber;
        /** account balance*/
        private double balance;
        
        /**
         * Constructor for the bank account
         * @param name customar Name
         * @param accountNumber  the account number
         * @param balance account balance
         */   
		public BankAccount(String name, String accountNumber, double balance) {
			super();
			this.name = name;
			this.accountNumber = accountNumber;
			this.balance = balance;
		}
		
		/**
         * get customar name
         * @return name
         */
		public String getName() {
			return name;
		}
		
		/**
         * set customar name
         * @param name
         */
		public void setName(String name) {
			this.name = name;
		}
		
		/**
         * get the account number
         * @return the account number
         */
		public String getAccountNumber() {
			return accountNumber;
		}
		
		/**
         * set account number
         * @param accountNumber
         */
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		
		/**
         * get the balance
         * @return balance
         */
		public double getBalance() {
			return balance;
		}
		
		/**
         * set the balance
         * @param balance
         */
		public void setBalance(double balance) {
			this.balance = balance;
		}
        
		
        
   

}  