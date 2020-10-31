package iao.zack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import iao.zack.model.Credit;

public class SaveCredit {

	public static boolean saveNewCredit(Credit c) {

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.createConnection();
			String query = "INSERT INTO Tcredit(numCredit,dateCredit,capitalCredit,dureeCredit,tauxCredit,annuiteCredit,client) values (NULL,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(query); // Making use of prepared statements here to insert bunch
																// of data
			preparedStatement.setString(1, c.getDate());
			preparedStatement.setDouble(2, c.getCapital());
			preparedStatement.setInt(3, c.getDuree());
			preparedStatement.setDouble(4, c.getTaux());
			preparedStatement.setDouble(5, c.getAnnuite());
			preparedStatement.setInt(6, c.getClientnum());

			int i = preparedStatement.executeUpdate();

			if (i != 0) // Just to ensure data has been inserted into the database
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

}
