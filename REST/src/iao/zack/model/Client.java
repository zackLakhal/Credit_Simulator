package iao.zack.model;

import java.io.Serializable;

public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numeroClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String ville;
	private String telephone;
	private String mail;
	private String motdepasse;

	public Client() {
	}

	public Client(int numeroClient, String nom, String prenom, String adresse, String ville, String telephone,
			String mail, String motdepasse) {

		this.numeroClient = numeroClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.telephone = telephone;
		this.mail = mail;
		this.motdepasse = motdepasse;
	}

	public Client(Client client) {
		this.numeroClient = client.numeroClient;
		this.nom = client.nom;
		this.prenom = client.prenom;
		this.adresse = client.adresse;
		this.ville = client.ville;
		this.telephone = client.telephone;
		this.mail = client.mail;
		this.motdepasse = client.motdepasse;
	}

	public int getNumeroClient() {
		return numeroClient;
	}

	public void setNumeroClient(int numeroClient) {
		this.numeroClient = numeroClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	@Override
	public String toString() {
		return "Client [numeroClient=" + numeroClient + ", prenom=" + prenom + ", adresse=" + adresse + ", ville="
				+ ville + ", telephone=" + telephone + ", mail=" + mail + "]";
	}

}
