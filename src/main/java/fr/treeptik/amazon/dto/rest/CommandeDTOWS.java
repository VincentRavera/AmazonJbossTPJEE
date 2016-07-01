package fr.treeptik.amazon.dto.rest;

import java.io.Serializable;
import java.util.Date;

public class CommandeDTOWS implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Date dateCommande;

	private Date dateLivraison;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

}
