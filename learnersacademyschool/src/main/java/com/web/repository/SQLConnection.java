package com.web.repository;

import java.sql.*;


public class SQLConnection {
	
	public Statement createConnection() {
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_learnersacademy","root","Samiksha123@!");
			statement = con.createStatement();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return statement;
	}
	
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_learnersacademy","root","Samiksha123@!");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return connection;
	}

}
