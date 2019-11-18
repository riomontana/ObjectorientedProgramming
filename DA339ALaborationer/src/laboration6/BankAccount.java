package laboration6;

import javax.swing.JOptionPane;

public class BankAccount {

	private String accountNbr;
	private double balance;
	private double interestRate;
	
	public void init(String accountNbr, double balance, double interestRate) {
		this.accountNbr = accountNbr;
		this.balance = balance;
		this.interestRate = interestRate;	
	}
	
	public String getAccountNbr() {
		return this.accountNbr;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double interestRate() {
		return this.interestRate;
	}
	
	public void info() {
		JOptionPane.showMessageDialog(null, "Account number: " + this.accountNbr + "\nBalance: " + this.balance);
	}
	
	public void deposit(double amount) {
		this.balance = this.balance + amount; 
	}
	
	public void withdrawal(double amount) {
		this.balance = this.balance - amount;
	}
}

