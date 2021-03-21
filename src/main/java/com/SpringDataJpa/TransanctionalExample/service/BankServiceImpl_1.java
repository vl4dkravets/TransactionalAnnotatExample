package com.SpringDataJpa.TransanctionalExample.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.SpringDataJpa.TransanctionalExample.dao.BankAccountDao;
import com.SpringDataJpa.TransanctionalExample.exception.InsufficientFundsException;
import com.SpringDataJpa.TransanctionalExample.model.Account;

@Service
public class BankServiceImpl_1 implements BankService{

	private BankAccountDao bankAccountDao;
		
	public BankServiceImpl_1(BankAccountDao bankAccountDao) {
		super();
		this.bankAccountDao = bankAccountDao;
	}


	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED, readOnly=false, rollbackFor=Exception.class )
	public void transferFunds(Account from, Account to, Long amount) {
		try {
			bankAccountDao.withdraw(from, to, amount);
			bankAccountDao.deposit(from, to, amount);
		} catch (InsufficientFundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
