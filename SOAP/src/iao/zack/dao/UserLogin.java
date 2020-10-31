package iao.zack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import iao.zack.model.Client;

public class UserLogin {

	public static Client validateUser(String email, String password) {

		Client client = new Client();
		Connection con = null;
		ResultSet resultSet = null;
		String emailDB = "";
		String passwordDB = "";

		try {

			con = DBConnection.createConnection();
			if (con != null) {

				PreparedStatement recherchePersonne = con
						.prepareStatement("select * from Tclient where mailClient = ? and mdpClient = ?");

				recherchePersonne.setString(1, email);
				recherchePersonne.setString(2, password);

				resultSet = recherchePersonne.executeQuery();

				while (resultSet.next()) // Until next row is present otherwise it return false
				{
					emailDB = resultSet.getString("mailClient"); // fetch the values present in database
					passwordDB = resultSet.getString("mdpClient");

					if (email.equals(emailDB) && password.equals(passwordDB)) {
						client.setAdresse(resultSet.getString("adresseClient"));
						client.setTelephone(resultSet.getString("phoneClient"));
						client.setVille(resultSet.getString("villeClient"));
						client.setMail(resultSet.getString("mailClient"));
						client.setPrenom(resultSet.getString("prenomClient"));
						client.setNumeroClient(resultSet.getInt("numClient"));
						client.setNom(resultSet.getString("nomClient"));

					}
				}
			} else {
				System.out.println("Erreur de connexion dans UserLogin.java");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return client;
	}

}
