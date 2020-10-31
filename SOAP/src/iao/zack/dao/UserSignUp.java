package iao.zack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import iao.zack.model.Client;

public class UserSignUp {

	public static boolean registerClient(Client c) {
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.createConnection();
			String query = "INSERT INTO Tclient(numClient,nomClient,prenomClient,adresseClient,villeClient,phoneClient,mailClient,mdpClient) values (NULL,?,?,?,?,?,?,?)"; // Insert
																																											// //
																																											// table
																																											// 'USERS'
			preparedStatement = con.prepareStatement(query); // Making use of prepared statements here to insert bunch
																// of data
			preparedStatement.setString(1, c.getNom());
			preparedStatement.setString(2, c.getPrenom());
			preparedStatement.setString(3, c.getAdresse());
			preparedStatement.setString(4, c.getVille());
			preparedStatement.setString(5, c.getTelephone());
			preparedStatement.setString(6, c.getMail());
			preparedStatement.setString(7, c.getMotdepasse());

			int i = preparedStatement.executeUpdate();

			if (i != 0) // Just to ensure data has been inserted into the database
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	public static boolean isExist(String email) {

		Connection con = null;
		ResultSet resultSet = null;
		String emailDB = "";

		try {

			con = DBConnection.createConnection();
			if (con != null) {
				PreparedStatement recherchePersonne = con
						.prepareStatement("select * from Tclient where mailClient = ? ");

				recherchePersonne.setString(1, email);

				resultSet = recherchePersonne.executeQuery();
				while (resultSet.next()) // Until next row is present otherwise it return false
				{
					emailDB = resultSet.getString("mailClient"); // fetch the values present in database

					if (email.equals(emailDB)) {
						return true;
					}
				}
			} else {
				System.out.println("Erreur de connextion dans UserSignUp.java");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

}
