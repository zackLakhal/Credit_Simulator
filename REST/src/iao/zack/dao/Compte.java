package iao.zack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import iao.zack.model.Credit;

public class Compte {

	public static LinkedList<Credit> getAllCredits(int id) {
		Connection con = null;

		ResultSet resultSet = null;
		LinkedList<Credit> list = null;

		try {

			con = DBConnection.createConnection();
			if (con != null) {
				PreparedStatement statement = con
						.prepareStatement("SELECT * FROM zackdb.tcredit where client = ? order by dateCredit desc");

				statement.setString(1, "" + id);

				resultSet = statement.executeQuery();

				list = new LinkedList<Credit>();

				while (resultSet.next()) // Until next row is present otherwise it return false
				{
					Credit c = new Credit();
					c.setNumero(resultSet.getInt("numCredit"));
					c.setAnnuite(resultSet.getDouble("annuiteCredit"));
					c.setCapital(resultSet.getDouble("capitalCredit"));
					c.setTaux(resultSet.getDouble("tauxCredit"));
					c.setDuree(resultSet.getInt("dureeCredit"));
					c.setDate(resultSet.getString("dateCredit"));
					list.add(c);

				}
			} else {
				System.out.println("Erreur de connexion dans Compte.java");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	public static Credit getCredit(int id) {
		Connection con = null;

		ResultSet resultSet = null;
		Credit c = null;
		try {

			con = DBConnection.createConnection();
			if (con != null) {
				PreparedStatement statement = con.prepareStatement("SELECT * FROM zackdb.tcredit where numCredit = ?");

				statement.setString(1, "" + id);

				resultSet = statement.executeQuery();

				while (resultSet.next()) // Until next row is present otherwise it return false
				{
					c = new Credit();
					c.setNumero(resultSet.getInt("numCredit"));
					c.setAnnuite(resultSet.getDouble("annuiteCredit"));
					c.setCapital(resultSet.getDouble("capitalCredit"));
					c.setTaux(resultSet.getDouble("tauxCredit"));
					c.setDuree(resultSet.getInt("dureeCredit"));
					c.setDate(resultSet.getString("dateCredit"));
					return c;

				}
			} else {
				System.out.println("Erreur de connexion dans Compte.java");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return c;
	}

	public static void deletCredit(int id) {
		Connection con = null;

		try {

			con = DBConnection.createConnection();
			if (con != null) {
				PreparedStatement statement = con.prepareStatement("DELETE FROM zackdb.tcredit where numCredit = ?");

				statement.setString(1, "" + id);

				statement.executeUpdate();

			} else {
				System.out.println("Erreur de connexion dans Compte.java");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
