package fr.treeptik.amazon.model;

import javax.persistence.Entity;

@Entity
public class Livre extends Article {

	private static final long serialVersionUID = 1L;
	
	private String auteur;
	
	private String editeur;
	
	private String genre;
	
	
	private String description;

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
