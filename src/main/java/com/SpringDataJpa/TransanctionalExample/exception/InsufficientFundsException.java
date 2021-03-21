package com.SpringDataJpa.TransanctionalExample.exception;

public class InsufficientFundsException extends Exception{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6669257601711804690L;

	public InsufficientFundsException(String message) {
		super(message);
	}
}
