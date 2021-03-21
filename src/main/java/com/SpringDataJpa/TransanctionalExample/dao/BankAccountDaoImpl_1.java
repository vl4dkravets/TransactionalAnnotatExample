package com.SpringDataJpa.TransanctionalExample.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.SpringDataJpa.TransanctionalExample.exception.InsufficientFundsException;
import com.SpringDataJpa.TransanctionalExample.model.Account;

@Repository
public class BankAccountDaoImpl_1 implements BankAccountDao{

	private JdbcTemplate jdbcTemplate;
	
	public BankAccountDaoImpl_1(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void withdraw(Account from, Account to, Long amount) throws InsufficientFundsException {
		Account account1 = getSenderAccount(from.getAccountNum());
		
		if(account1.getBalance() >= amount) {
			Double newBalance = account1.getBalance() - amount;
			
			String sql = "UPDATE bank_table SET balance = ? WHERE account_number = ?";
			int updateResult = jdbcTemplate.update(sql, newBalance, from.getAccountNum());
			
			if(updateResult >0) {
				System.out.println("Amount $"+amount+ " was withdrawn from"
						+ " Account #"+from.getAccountNum());
			}
		} 
		else {
			throw new InsufficientFundsException("Insufficient account balance");
		}
		
		
	}

	@Override
	public void deposit(Account from, Account to, Long amount) {
		Account account1 = getSenderAccount(to.getAccountNum());
		Double newBalance = account1.getBalance() + amount;
	
		String sql = "UPDATE bank_table SET balance = ? WHERE account_number = ?";
		int updateResult = jdbcTemplate.update(sql, newBalance, to.getAccountNum());
		
		if(updateResult >0) {
			System.out.println("Amount $"+amount+ " was deposited to"
					+ " Account #"+ to.getAccountNum());
		}
	}

	private Account getSenderAccount(Long accountNum) {
		String sql = "SELECT * FROM bank_table WHERE account_number=?";
		
		Account account1 = jdbcTemplate.queryForObject(sql, new AccountRowMapper(), accountNum);
		return account1;
	}
}
