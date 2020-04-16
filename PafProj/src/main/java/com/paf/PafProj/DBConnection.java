package com.paf.PafProj;

import java.sql.*;

public class DBConnection {

	Connection con;

	public Connection connect() {

		Connection con1 = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/payment", "root", "");

			// Connection Message
			System.out.println("Database Connection Successful");

		} catch (Exception e) {

			// Connection Message
			e.printStackTrace();
			System.out.println("Database Connection Failed");

		}

		return con1;
	}

	
	
	
	public Connection getCon() {
		return con;
	}

	public Statement GtStatement() throws SQLException {
		Statement stat = con.createStatement();
		return stat;
	}

	public ResultSet GtResultSet(String query) throws SQLException {
		Statement Stat = GtStatement();
		ResultSet Result = Stat.executeQuery(query);
		return Result;
	}

	public PreparedStatement GtPrepStatement(String query) throws SQLException {
		PreparedStatement PrepStat = con.prepareStatement(query);
		return PrepStat;
	}

}
