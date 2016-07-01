package fr.treeptik.amazon.dto.webservice;

import java.io.Serializable;
import java.util.Date;

public class UtilisateurDTORest implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nom;
	
	private String prenom;
	
	private String adresse;
	
	private Date naissance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

}
