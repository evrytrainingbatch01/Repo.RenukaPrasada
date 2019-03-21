package com.evrybank.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.evrybank.user.model.Customer;

public class EvryBankCustomerDaoImpl implements EvryBankCustomerDao {
	public Connection connection = null;

	@Override
	public List<Customer> viewAccountDetails(String userName) {

		List<Customer> customers = new ArrayList<Customer>();
		Customer customer;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/evrybank_customer_details?useSSL=false", "RenukaPrasada",
					"Arpithavs@24");
			PreparedStatement statement = connection.prepareStatement(
					"SELECT id,firstname,lastname, age, country, mobile,email from evrybank_customer_details.customer where username='"
							+ userName + "'");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				customer = new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setFirstName(resultSet.getString("firstname"));
				customer.setLastName(resultSet.getString("lastname"));
				customer.setLastName(resultSet.getString("age"));
				customer.setCountry(resultSet.getString("country"));
				customer.setMobile(resultSet.getString("mobile"));
				customer.setEmail(resultSet.getString("email"));

				customers.add(customer);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// System.out.println(customers + "kkk");
		return customers;

	}

	@Override
	public boolean addMoney(int id, int amount) {

		int result = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/evrybank_customer_details?useSSL=false", "RenukaPrasada",
					"Arpithavs@24");
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO evrybank_customer_details.account values (?, ?");
			statement.setInt(1, id);
			statement.setFloat(2, amount);
			statement.executeUpdate();
			result = statement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return (result == 1) ? true : false;

	}

}
