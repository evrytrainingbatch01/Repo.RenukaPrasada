package com.org.JdbcTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

	
		
		 public void  conect(){
			 
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");  //type 4 driver
			System.out.println("-------- connection is established ------------");
			}catch(Exception e) {
				System.out.println(e);
				
				
				
				
			}
			try {
				 Connection conn=null ;
				
				 conn = DriverManager
				        .getConnection("jdbc:mysql://localhost:3306/evrybank_customer_details", "RenukaPrasada", "Arpithavs@24");
				
			
				
			} catch (SQLException e) {
				
				System.out.println("connection failed! check the URL, userName and Password");
				e.printStackTrace();
			}
	            System.out.println("SQL Connection to database established!");
			
				

	}
	}

