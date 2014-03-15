package com.seascape.enterprise.secure.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seascape.enterprise.entity.UserAccount;

public class DataConnector {

	public static Connection getConnection() {

		String jdbcUrl = "jdbc:mysql://localhost:3306/xydbprod?user=root&password=admin";
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(jdbcUrl);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e2) {
			e2.printStackTrace();
		} catch (IllegalAccessException e3) {
			e3.printStackTrace();
		} catch (SQLException e4) {
			e4.printStackTrace();
		}

		return conn;
	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException sqlerr) {
			sqlerr.printStackTrace();
		}
	}


}
