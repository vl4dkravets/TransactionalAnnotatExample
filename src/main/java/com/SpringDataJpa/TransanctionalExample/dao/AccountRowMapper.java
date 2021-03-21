package com.SpringDataJpa.TransanctionalExample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.SpringDataJpa.TransanctionalExample.model.Account;

public class AccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account1 = new Account();
		account1.setAccountNum(rs.getLong("account_number"));
		account1.setAccountType(rs.getString("account_type"));
		account1.setBalance(rs.getDouble("balance"));
		account1.setHolderName(rs.getString("account_holder"));
		return account1;
	}

}
