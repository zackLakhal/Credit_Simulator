package iao.zack.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection createConnection() {

		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/zackdb";

		String username = "root"; //
		String password = "";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

}
