package com.tap.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tap.Entity.Account;
import com.tap.Repository.AccountRepo;

@Service
public class AccountServiceImpli implements AccountService {

	@Autowired
	AccountRepo repo;
	
	@Override
	public Account createAccount(Account account) {
		Account savedaccount = repo.save(account);
		return savedaccount;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not Present");
		}
		Account account_found = account.get();
		return account_found;
	}

	@Override
	public List<Account> getAllDetails() {
		List<Account> listOfAccount = repo.findAll();
		return listOfAccount;
	}

	
	@Override
	public Account depositeAmount(Long accountNumber, Double amount) {
		 if (amount == null) {
		        throw new IllegalArgumentException("Amount cannot be null");
		    }

		    Optional<Account> account = repo.findById(accountNumber);
		    if (account.isEmpty()) {
		        throw new RuntimeException("Account is not present");
		    }

		    Account accountPresent = account.get();
		    Double totalBalance = accountPresent.getBalance() + amount;
		    accountPresent.setBalance(totalBalance);
		    repo.save(accountPresent);
		    return accountPresent;
		}


	@Override
	public Account withDrawAmount(Long accountNumber, Double amount) {
		if (amount == null) {
	        throw new IllegalArgumentException("Amount cannot be null");
	    }

	    Optional<Account> account = repo.findById(accountNumber);
	    if (account.isEmpty()) {
	        throw new RuntimeException("Account is not present");
	    }

	    Account accountPresent = account.get();
	    Double accountBalance= accountPresent.getBalance()-amount;
	    accountPresent.setBalance(accountBalance);
	    repo.save(accountPresent);
		return accountPresent;
	}

	@Override
		public void closeAccount(Long accountNumber) {
			getAccountDetailsByAccountNumber(accountNumber);
			repo.deleteById(accountNumber);
		}

	
}



