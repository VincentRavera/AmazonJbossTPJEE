package fr.treeptik.amazon.managedbean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;

import org.jboss.logging.Logger;

import fr.treeptik.amazon.model.Commande;
import fr.treeptik.amazon.model.Utilisateur;
import fr.treeptik.amazon.service.CommandeService;
import fr.treeptik.amazon.service.UtilisateurService;

@ManagedBean
@RequestScoped
public class CommandeManagedBean {
	
	Logger log = Logger.getLogger(CommandeManagedBean.class);

	@EJB
	private CommandeService commandeService;

	@EJB
	private UtilisateurService userService;

	private Commande commande = new Commande();
	
	private ListDataModel<Commande> commandes = new ListDataModel<>();

	private ListDataModel<Utilisateur> users = new ListDataModel<>();

	@PostConstruct
	public void init() {
		this.commandes.setWrappedData(commandeService.findAll());
	}
	
	
	public String create() {
		commande = commandeService.save(commande);
		return "commande-list";

	}

	public ListDataModel<Utilisateur> getUsers() {
		users.setWrappedData(userService.findAll());
		return users;
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
		return commandes;
	}

}
