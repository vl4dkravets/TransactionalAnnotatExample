package com.SpringDataJpa.TransanctionalExample.service;

import com.SpringDataJpa.TransanctionalExample.model.Account;

public interface BankService {

	public abstract void transferFunds(Account from, Account to, Long amount);
}
