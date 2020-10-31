package iao.zack.model;

import java.io.Serializable;

public class Credit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numero;
	private int clientnum;
	private double annuite;
	private double capital;
	private double taux;
	private int duree;
	private String date;

	public Credit() {
	}

	public Credit(int numero, int clientnum, double annuite, double capital, double taux, int duree, String date) {
		this.numero = numero;
		this.clientnum = clientnum;
		this.annuite = annuite;
		this.capital = capital;
		this.taux = taux;
		this.duree = duree;
		this.date = date;

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getClientnum() {
		return clientnum;
	}

	public void setClientnum(int clientnum) {
		this.clientnum = clientnum;
	}

	public double getAnnuite() {
		return annuite;
	}

	public void setAnnuite(double annuite) {
		this.annuite = annuite;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Credit [numero=" + numero + ", clientnum=" + clientnum + ", annuite=" + annuite + ", capital=" + capital
				+ ", taux=" + taux + ", duree=" + duree + ", date=" + date + "]";
	}

}
