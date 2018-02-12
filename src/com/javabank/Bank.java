package com.javabank;

public class Bank {
	private Account[] accounts = new Account[10];
	private int totalAccount;
	
	public void addAccount(String accountNo, String name) {
		accounts[totalAccount++] = new Account(accountNo, name);
	}
	
	public void addAccount(String accountNo, String name, long balance) {
        accounts[totalAccount++] = new Account(accountNo, name, balance);
    }
	
	public Account getAccount(String accountNo) {
		for(int i = 0; i < totalAccount; i++) {
			if(accountNo.equals(accounts[i].getAccountNo())) {
				return accounts[i];
			}
		}
		return null;
	}
	
	public Account[] findAccountByName(String name) {
		Account[] temp = new Account[totalAccount];
		int total = 0;
		for(int i = 0; i < totalAccount; i++) {
			if(name.equals(accounts[i].getName())){
				temp[total++] = accounts[i];
			}
		}
		Account[] matched = new Account[total];
		for(int i = 0; i < total; i++) {
			matched[i] = temp[i];
		}
		return matched;
	}
	
	public Account[] getAccounts() {
		return accounts;
	}
	
	public int getTotalAccount() {
		return totalAccount;
	}
}
