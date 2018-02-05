package com.cgi.metier.test;


import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;

import com.cgi.dao.BankAccountDao;
import com.cgi.dao.implementation.BankAccountDaoImpl;
import com.cgi.metier.implementation.BankAccountMetierImlp;
import com.cgi.model.BankAccount;

public class BankAccountMetierTest {
	
	BankAccountMetierImlp accountMetier = new BankAccountMetierImlp();
	

	/**Mock dao object*/
	BankAccountDao accountDaoMock = Mockito.mock(BankAccountDaoImpl.class);
	
	/** initialize the list bankAccounts that will represent all bank accounts */
	Map<String, BankAccount> bankAccounts = new HashMap<String, BankAccount>();	
	
	@Before
	public void initialize() {
		
				
		bankAccounts.put("FR001234", new BankAccount("Baptiste", "FR001234", 1000));
		bankAccounts.put("FR122349", new BankAccount("Mickael", "FR122349", 10000));
		bankAccounts.put("FR679873", new BankAccount("Xavier", "FR679873", 100000));
		
		accountMetier.setBankAccountDao(accountDaoMock);
	}
	
	/**
	 * Test the deposit method
	 */
	@Test
	public void should_return_twenty_thousand_when_amount_is_ten_thousand_and_balance_is_ten_thousand(){
		
	
		BankAccount account = bankAccounts.get("FR122349"); 
		
		Mockito.when(accountDaoMock.deposit(10000, account)).thenReturn(20000.0);
		
		accountMetier.deposit(10000, account);
		
		Assert.assertEquals(20000, account.getBalance(), 0.0);		
	}
	
	@Test
	public void should_throw_exception_when_amount_is_less_than_or_equal_zero() {
	
		try {

			BankAccount account = bankAccounts.get("FR122349"); 
			Mockito.when(accountDaoMock.deposit(-1000, account)).thenThrow(new IllegalArgumentException());
			accountMetier.deposit(-1000, account);
			
		}catch(IllegalArgumentException e){
			Assert.assertEquals(e.getMessage(), "The amount must be greater than zero");
		}
	}
	
	/**
	 * Test the withdraw method
	 */
	@Test
	public void should_return_five_hundred_when_amount_is_five_hundred_and_balance_is_thousand() {
		
		  BankAccount account = bankAccounts.get("FR001234"); 
		  
		  Mockito.when(accountDaoMock.withdraw(500, account)).thenReturn(500.0);
		  accountMetier.withdraw(500, account);
		
		  Assert.assertEquals(500, account.getBalance(), 0.0); 
	} 
	
	@Test
	public void should_return_exception_when_amount_is_less_than_or_equal_zero() {
	  try {

		  BankAccount account = bankAccounts.get("FR122349"); 
		  Mockito.when(accountDaoMock.deposit(-1000, account)).thenThrow(new IllegalArgumentException());
		  accountMetier.deposit(-1000, account);
			
		}catch(IllegalArgumentException e){
			Assert.assertEquals(e.getMessage(), "The amount must be greater than zero");
		}
	}
	
	@Test
	public void should_throw_exception_when_amount_is_greater_than_balance() {
		
		try {

			BankAccount account = bankAccounts.get("FR122349"); 
			Mockito.when(accountDaoMock.deposit(-1000, account)).thenThrow(new IllegalArgumentException());
			accountMetier.deposit(-1000, account);
				
		}catch(IllegalArgumentException e){
				Assert.assertEquals(e.getMessage(), "The amount is greater than the balance");
		}
	 }
}
