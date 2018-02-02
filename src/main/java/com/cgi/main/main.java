package com.cgi.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cgi.metier.BankAccountMetier;
import com.cgi.model.BankAccount;

public class main {

	public static void main(String[] args) {
		
		/** initialize the list bankAccounts that will represent all bank accounts */
		Map<String, BankAccount> bankAccounts = new HashMap<String, BankAccount>();		
		bankAccounts.put("FR001234", new BankAccount("Baptiste", "FR001234", 1000));
		bankAccounts.put("FR122349", new BankAccount("Mickael", "FR122349", 10000));
		bankAccounts.put("FR679873", new BankAccount("Xavier", "FR679873", 100000)); 
		
		/** load the business object*/
		ClassPathXmlApplicationContext  context = 
				new ClassPathXmlApplicationContext(new String[]{"config.xml"});
		BankAccountMetier bankAccountMetier = (BankAccountMetier)  context.getBean("metier");
		
		/**initialize option to read the option choosen by the client from A, B, C, D, or E*/
		char option='\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your account number");
		String accountNumber = scanner.next();
		System.out.println("\n");
		System.out.println("A. Check  balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Printing statement");
		System.out.println("E. Exit");
		
		do {
			System.out.println("===================");
			System.out.println("Enter an option");
			System.out.println("===================");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch(option) {
			
			case 'B' : 
				System.out.println("===================");
				System.out.println("Enter an amount to deposit");
				System.out.println("===================");
				double amount = scanner.nextDouble();
				bankAccountMetier.deposit(amount, accountNumber, bankAccounts);
				System.out.println("\n");
				break;
				
			case 'A' : 
				System.out.println("===================");
				System.out.println("balance = " + bankAccounts.get(accountNumber).getBalance());
				System.out.println("===================");
				System.out.println("\n");
				break;
				
			case 'C' : 
				System.out.println("===================");
				System.out.println("Enter an amount to withdraw");
				System.out.println("===================");
				double amountTowithdraw = scanner.nextDouble();
				bankAccountMetier.withdraw(amountTowithdraw, accountNumber, bankAccounts);
				System.out.println("\n");
				break;
			
			case 'D' : 
				System.out.println("===================");
				System.out.println("Operation ");
				System.out.println("\n");
				bankAccountMetier.checkOperation(accountNumber);
				System.out.println("===================");
				System.out.println("\n");
				break;
				
			default :
				System.out.println("Invalid Option !!. Please enter again");
			}
			
			
		}while(option != 'E');
		
		System.out.println("Thank You for using our services");
		
	}

}
