package fr.treeptik.amazon.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;

import fr.treeptik.amazon.model.Commande;
import fr.treeptik.amazon.model.Utilisateur;
import fr.treeptik.amazon.service.CommandeService;

@ManagedBean
@RequestScoped
public class CommandeManagedBean {
	
	@EJB
	private CommandeService commandeService;
	
	private Commande commande;
	
	private ListDataModel<Commande> commandes = new ListDataModel<>();
	
	private ListDataModel<Utilisateur> users = new ListDataModel<>();
	
	public void selectUser(){
		commande.setClient(users.getRowData());
	}
	
	public String create(){
		commande = commandeService.save(this.commande);
		return "commande-list";
		
	}
	public String updateComm() {
		commande = commandes.getRowData();
		return "commande";
	}
	public String addComm() {
		commande = new Commande();
		return "commande";
	}
	public String deleteComm() {
		System.out.println("Del Del TEst");
		commande = commandes.getRowData();
		commandeService.remove(commande);
		return "commande-list";
	}
	
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public ListDataModel<Commande> getCommandes() {
		this.commandes.setWrappedData(commandeService.findAll());
		return commandes;
	}
	
	
}
