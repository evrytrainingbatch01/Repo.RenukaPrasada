package com.evrybank.customer.service;

import java.util.List;

import com.evrybank.customer.dao.EvryBankCustomerDao;
import com.evrybank.customer.dao.EvryBankCustomerDaoImpl;
import com.evrybank.customer.service.EvryBankCustomerService;
import com.evrybank.user.model.Account;
import com.evrybank.user.model.Customer;


public class EvryBankCustomerServiceImpl implements EvryBankCustomerService{
	
	EvryBankCustomerDao evrybankcustomerdao=new EvryBankCustomerDaoImpl();

	public static void main(String[] args) {

	}

	

	@Override
	public List<Customer> viewAccountDetails(String userName) {
		// TODO Auto-generated method stub
		return evrybankcustomerdao.viewAccountDetails(userName);
	}

	@Override
	public boolean sendMoney() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int withdrawMoney() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean loanRequest() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean addMoney(int id, int amount) {
		// TODO Auto-generated method stub
		return evrybankcustomerdao.addMoney(id,amount);
	}

	

}
