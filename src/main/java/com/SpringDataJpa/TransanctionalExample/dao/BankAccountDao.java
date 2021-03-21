package com.SpringDataJpa.TransanctionalExample.dao;

import com.SpringDataJpa.TransanctionalExample.exception.InsufficientFundsException;
import com.SpringDataJpa.TransanctionalExample.model.Account;

public interface BankAccountDao {

	public abstract void withdraw(Account from, Account to, Long amount) throws InsufficientFundsException;
	public abstract void deposit(Account from, Account to, Long amount) throws InsufficientFundsException;

}
