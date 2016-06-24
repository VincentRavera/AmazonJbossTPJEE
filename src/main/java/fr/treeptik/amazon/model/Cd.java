package fr.treeptik.amazon.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cd extends Article{

	private static final long serialVersionUID = 1L;
	
	private String genre;
	
	private String artiste;
	
	private String compositeur;
	
	private Double nbDeChanson;
	
	@Temporal(TemporalType.TIME)
	private Date duree;
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getArtiste() {
		return artiste;
	}

	public void setArtiste(String artiste) {
		this.artiste = artiste;
	}

	public String getCompositeur() {
		return compositeur;
	}

	public void setCompositeur(String compositeur) {
		this.compositeur = compositeur;
	}

	public Double getNbDeChanson() {
		return nbDeChanson;
	}

	public void setNbDeChanson(Double nbDeChanson) {
		this.nbDeChanson = nbDeChanson;
	}

	public Date getDuree() {
		return duree;
	}

	public void setDuree(Date duree) {
		this.duree = duree;
	}

}
