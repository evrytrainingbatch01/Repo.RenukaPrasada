package com.org.Evrybank.MainApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.org.JdbcTesting.JdbcConnection;

public class UserMainApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Evry Banking System");

		System.out.println("Enter the User Crediantials whether Customer or Admin");

		System.out.println("Login for Customer Press :1");
		System.out.println("Login for Admin Press Admin:2");

		int select = sc.nextInt();

		System.out.println("");

		if (select == 1) {

			System.out.println("Enter User Name :");
			String username = sc.next();

			System.out.println("Enter Password :");
			String password = sc.next();

			UserValidater(username, password);

		}

		else if (select == 2) {

		}

	}

	private static void UserValidater(String username, String password) {
		
	
		    
		        JdbcConnection db = new JdbcConnection();
		        db.conect();
		       
		        try{
		        	

			        Connection conn= null;
			       Statement stmt = null;
			       stmt = conn.createStatement();
			       
			       
					ResultSet rs =stmt.executeQuery("select username,password from customer");
					
		            while (rs.next()) {
		                String user = rs.getString("username");
		                String pass=rs.getString("password");
		                System.out.println(username);
		            
		            
		            if(username!=user && password!=pass) {
		            	
		            	System.out.println("Welcome  "+user);
		            	
		            }else {System.out.println("Invalid UserName and Password");
		            }
		            
		            
		            }
		        } catch(SQLException ex){
		            ex.getMessage();
		        }
		        

	


	}
	
}
