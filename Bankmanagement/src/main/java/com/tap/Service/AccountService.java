package com.tap.Service;

import java.util.List;

import com.tap.Entity.Account;

public interface AccountService {
	
	public Account createAccount(Account account);
	public Account getAccountDetailsByAccountNumber(Long accountNumber);
	public List<Account> getAllDetails();
	public Account depositeAmount(Long accountNumber, Double amount);
	public Account withDrawAmount(Long accountNumber, Double amount);
	public void closeAccount(Long accountNumber);
	
	
	

}


