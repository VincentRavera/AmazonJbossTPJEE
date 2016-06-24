package fr.treeptik.amazon.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Dvd extends Article{

	private static final long serialVersionUID = 1L;
	
	private String realisateur;
	
	private String genre;
	
	@Temporal(TemporalType.TIME)
	private Date duree;

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getDuree() {
		return duree;
	}

	public void setDuree(Date duree) {
		this.duree = duree;
	}
	
	
	

}
