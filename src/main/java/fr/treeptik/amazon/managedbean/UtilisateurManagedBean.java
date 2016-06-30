package fr.treeptik.amazon.managedbean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import org.jboss.logging.Logger;
import org.primefaces.event.RowEditEvent;

import fr.treeptik.amazon.model.Utilisateur;
import fr.treeptik.amazon.service.UtilisateurService;

@ManagedBean
@RequestScoped
public class UtilisateurManagedBean {

	Logger logger = Logger.getLogger(UtilisateurManagedBean.class);
	
	@EJB
	private UtilisateurService userService;

	private Utilisateur utilisateur = new Utilisateur();

	private ListDataModel<Utilisateur> utilisateurs = new ListDataModel<>();
	
	@PostConstruct
	public void init() {
		utilisateurs.setWrappedData(userService.findAll());
	}

	public ListDataModel<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public String create() {
		utilisateur = userService.save(utilisateur);
		return "user-list";
	}
	public String createInCommand() {
		utilisateur = userService.save(utilisateur);
		return "commande";
	}
	public String update() {
		utilisateur = utilisateurs.getRowData();
		return "user";
	}
	public String add() {
		utilisateur = new Utilisateur();
		return "user";
	}
	public String delete() {
		utilisateur = utilisateurs.getRowData();
		userService.remove(utilisateur);
		utilisateurs = this.getUtilisateurs();
		return "user-list";
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void onRowEdit(RowEditEvent event) {
		utilisateur = (Utilisateur) event.getObject();
		utilisateur = userService.save(utilisateur);
		utilisateurs = this.getUtilisateurs();
		FacesMessage msg = new FacesMessage("Car Edited" + ((Utilisateur) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("user:" + utilisateur.getId() + "-" + utilisateur.getNom() + "-" + utilisateur.getPrenom()
		+ "-" + utilisateur.getAdresse());
	}

}
