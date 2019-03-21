package com.evrybank.customer.service;

import java.util.List;

import com.evrybank.user.model.Account;
import com.evrybank.user.model.Customer;

public interface EvryBankCustomerService {
	
	
	public boolean addMoney(final int id,final int amount);
	
	public List<Customer> viewAccountDetails(String userName);
	
	public boolean sendMoney();
	public int withdrawMoney();
	public boolean loanRequest();

	public List<Account> withdrawMoney(int wid);
	
	
}
