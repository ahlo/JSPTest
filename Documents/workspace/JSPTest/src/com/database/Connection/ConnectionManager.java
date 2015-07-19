package com.database.Connection;

import java.sql.*;

public class ConnectionManager {

	static final String serverName = "localhost";
	static final String portNumber = "3306";
	static final String databaseName = "JSPTest";
	static final String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + "databaseName";
	static final String userName = "admin";
	static final String password = "admin";

	public static Connection getConnection() throws SQLException{
		Connection con = null;
		try {
			//Load the JDBC MySQL Bridge Driver
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,userName,password);
			System.out.println("Database connection successful: " + url);
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
				System.out.println("Database connection closed.");
			}
			catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Database connection cannot be closed.");
			}
		}
	}
}