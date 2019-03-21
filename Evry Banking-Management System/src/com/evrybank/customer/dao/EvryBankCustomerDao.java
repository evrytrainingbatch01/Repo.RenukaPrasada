package com.evrybank.customer.dao;

import java.util.List;

import com.evrybank.user.model.Account;
import com.evrybank.user.model.Customer;

public interface EvryBankCustomerDao {
	
	public List<Customer> viewAccountDetails(String userName);

	public boolean addMoney(int id, int amount);

	public List<Account> withdrawMoney(int wid);

}
