package com.database.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {

	//Login information
	static final String serverName = "localhost";
	static final String portNumber = "3306";
	static final String databaseName = "mydb";
	static final String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + databaseName;
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
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
				System.out.println("Result set closed.");
			}
			catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Result set cannot be close.");
			}
		}
	}
	
	public static void closePreparedStatement(PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
				System.out.println("Prepared statement closed.");
			}
			catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Prepared statement cannot be closed.");
			}
		}
	}
}