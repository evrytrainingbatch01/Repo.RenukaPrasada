package com.evrybank.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.evrybank.admin.dao.EvryBankAdminDao;
import com.evrybank.user.model.Customer;

public class EvryBankAdminDaoImpl implements EvryBankAdminDao {
	public Connection connection = null;
	public int access = 2;

	@Override
	public int checkUser(final String userName, final String password) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/evrybank_customer_details?useSSL=false", "RenukaPrasada",
					"Arpithavs@24");
			PreparedStatement statement = connection.prepareStatement(
					"SELECT * FROM evrybank_customer_details.customer where username = ? AND password = ?");
			statement.setString(1, userName);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				access = resultSet.getInt("access");
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
		return access;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		int id = customer.getId();
		String firstname = customer.getFirstName();
		String lastname = customer.getLastName();
		String age = customer.getAge();
		String country = customer.getCountry();
		String mobile = customer.getMobile();
		String email = customer.getEmail();
		
		String username = customer.getUsername();
		String password = customer.getPassword();
		int access = customer.getAccess();
		
		
		
		int result = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/evrybank_customer_details?useSSL=false", "RenukaPrasada",
					"Arpithavs@24");
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO evrybank_customer_details.customer values (?, ?, ?, ?, ?, ?, ?,?,?,?)");
			statement.setInt(1, id);
			statement.setString(2, firstname);
			statement.setString(3, lastname);
			statement.setString(4, age);
			statement.setString(5, country);
			statement.setString(6, mobile);
			statement.setString(7, email);
		
			statement.setString(8, username);
			statement.setString(9, password);
			statement.setInt(10, access);
			statement.executeUpdate();

          

            
			/*
			 * System.out.println(id); System.out.println(firstname);
			 * System.out.println(lastname); System.out.println(age);
			 * System.out.println(country); System.out.println(mobile);
			 * System.out.println(email);
			 */
			

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

	@Override
	public boolean deleteCustomer(int id) {
		int result = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/evrybank_customer_details?useSSL=false", "RenukaPrasada",
					"Arpithavs@24");
			PreparedStatement statement = connection
					.prepareStatement("DELETE FROM evrybank_customer_details.customer where id = ?");
			statement.setInt(1, id);

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

	@Override
	public List<Customer> viewAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/evrybank_customer_details?useSSL=false", "RenukaPrasada",
					"Arpithavs@24");
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM evrybank_customer_details.customer");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				customer = new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setFirstName(resultSet.getString("firstname"));
				customer.setLastName(resultSet.getString("lastname"));
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
	public boolean addMoney(int cid, int amount) {
		int result = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking?useSSL=false", "root",
					"root");
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO banking.customer (amount) values (?) where cid = ?");
			statement.setInt(1, amount);
			statement.setInt(2, cid);

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
