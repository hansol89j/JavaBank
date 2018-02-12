package com.javabank;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.crypto.Data;

public class Account {
	private String accountNo;
	private String name;
	private long balance;
	private Transaction[] transactions = new Transaction[100];
	private int totalTransaction;
	
	static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
	static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
	
	static final String DEPOSIT = "deposit";
	static final String WITHDRAW = "withdraw";
	
	public Account(String accountNo, String name) {
		this.name = name;
		this.accountNo = accountNo;
	}
	
	public Account(String accountNo, String name, long balance) {
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}
	
	public void deposit(long amount) {
		balance += amount;
		Transaction transaction = new Transaction();
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		transaction.setTransactionDate(Account.DATE_FORMAT.format(date));
		transaction.setTransactionTime(Account.TIME_FORMAT.format(date));
		transaction.setAmount(amount);
		transaction.setKind(Account.DEPOSIT);
		transaction.setBalance(this.balance);
		transactions[totalTransaction++] = transaction;
	}
	
	public void withdraw(long amount) {
		if(amount > balance) {
			return;
		}
		
		balance -= amount;
		Transaction transaction = new Transaction();
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		transaction.setTransactionDate(Account.DATE_FORMAT.format(date));
		transaction.setTransactionTime(Account.TIME_FORMAT.format(date));
		transaction.setAmount(amount);
		transaction.setKind(Account.WITHDRAW);
		transaction.setBalance(this.balance);
		transactions[totalTransaction++] = transaction;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public Transaction[] getTransactions() {
		return transactions;
	}
	public void setTransactions(Transaction[] transactions) {
		this.transactions = transactions;
	}
	public int getTotalTransaction() {
		return totalTransaction;
	}
	public void setTotalTransaction(int totalTransaction) {
		this.totalTransaction = totalTransaction;
	}
	
	@Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(accountNo);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(balance);

        return sb.toString();
    }
}
