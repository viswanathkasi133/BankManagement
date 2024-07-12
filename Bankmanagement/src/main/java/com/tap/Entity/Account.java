package com.tap.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long account_Number;
	@Column
	private String holderName;
	@Column
	private Double balance;
	
	
	public Account() {
		// TODO Auto-generated method stub
	}
	
	
	public Account(String holderName, Double balance) {
		super();
		this.holderName = holderName;
		this.balance = balance;
	}


	public Long getAccount_Number() {
		return account_Number;
	}
	public void setAccount_Number(Long account_Number) {
		this.account_Number = account_Number;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankEntity [account_Number=" + account_Number + ", holderName=" + holderName + ", balance=" + balance
				+ "]";
	}
	
	
}
