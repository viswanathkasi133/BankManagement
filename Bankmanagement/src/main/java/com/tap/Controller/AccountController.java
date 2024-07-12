package com.tap.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tap.Entity.Account;
import com.tap.Service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService service;
	
	//Creating Account
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account createAccount = service.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
	}
	@GetMapping("/{accountNumber}")
	public Account getAccountByAccountNumber(@PathVariable Long accountNumber) {
		Account account = service.getAccountDetailsByAccountNumber(accountNumber);
		return account;
		
	}
	
	@GetMapping("/getallaccounts")
	public List<Account> getAllAccountdetails(){
		List<Account> allDetails = service.getAllDetails();
		return allDetails;
		
	}
	
	@PutMapping("/deposite/{accountNumber}/{amount}")
	public Account depositeAmount(@PathVariable Long accountNumber, @PathVariable Double amount) {
	    Account depositemoney = service.depositeAmount(accountNumber, amount);
	    return depositemoney;
	}
	
	@PutMapping("/withdraw/{accountNumber}/{amount}")
	public Account withDrawAmount(@PathVariable Long accountNumber, @PathVariable Double amount) {
		Account account = service.withDrawAmount(accountNumber, amount);
		return account;
	}
	
	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber) {
		service.closeAccount(accountNumber);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account Closed");
	}
	
	
}


