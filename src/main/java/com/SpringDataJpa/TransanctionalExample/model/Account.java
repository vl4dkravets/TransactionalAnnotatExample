package com.SpringDataJpa.TransanctionalExample.model;

public class Account {
	
	private Long accountNum;
	private String accountType;
	private Double balance;
	private String holderName;
	
	public Account() {}
	
	public Account(Long accountNum, String accountType, Double balance, String holderName) {
		super();
		this.accountNum = accountNum;
		this.accountType = accountType;
		this.balance = balance;
		this.holderName = holderName;
	}
	
	public Long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Long l) {
		this.accountNum = l;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	
	@Override
	public String toString() {
		return "Account [accountNum=" + accountNum + ", accountType=" + accountType + ", balance=" + balance
				+ ", holderName=" + holderName + "]";
	}
	
	
	
	
}

