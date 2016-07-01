package fr.treeptik.amazon.ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import fr.treeptik.amazon.dto.webservice.UtilisateurDTORest;
import fr.treeptik.amazon.model.Utilisateur;
import fr.treeptik.amazon.service.UtilisateurService;

@Path("utilisateurs")
@Produces(value="application/json")
@Consumes(value="application/json")
@ApplicationPath("rest")
@Stateless
public class UtilisateurRessources extends Application {
	
	@EJB
	private UtilisateurService userService;
	
	@POST
	public UtilisateurDTORest saveUtilisateur(UtilisateurDTORest user) {
		Utilisateur utilisateur = this.castToDB(user);
		utilisateur = userService.save(utilisateur);
		return this.extactDB(utilisateur);
	}
	
	@DELETE
	public void removeUtillisateur(UtilisateurDTORest user) {
		Utilisateur utilisateur = this.castToDB(user);
		userService.remove(utilisateur);
	}
	
	@PUT
	public UtilisateurDTORest updateUtilisateur(UtilisateurDTORest user) {
		Utilisateur utilisateur = this.castToDB(user);
		utilisateur = userService.save(utilisateur);
		return this.extactDB(utilisateur);
	}
	
	@GET
	public List<UtilisateurDTORest> findAllUtilisateur() {
		List<UtilisateurDTORest> users = new ArrayList<>();
		List<Utilisateur> utilisateurs = userService.findAll();
		for (Utilisateur utilisateur : utilisateurs) {
			users.add(this.extactDB(utilisateur));
		}
		return users;
	}
	
	@GET
	@Path("{id}")
	public UtilisateurDTORest findByIdUtilisateur(@PathParam("id") Integer id) {
		Utilisateur utilisateur = userService.findById(id);
		return this.extactDB(utilisateur);
	}
	
	private UtilisateurDTORest extactDB(Utilisateur utilisateur) {
		UtilisateurDTORest user = new UtilisateurDTORest();
		user.setId(utilisateur.getId());
		user.setNom(utilisateur.getNom());
		user.setPrenom(utilisateur.getPrenom());
		user.setAdresse(utilisateur.getAdresse());
		user.setNaissance(utilisateur.getNaissance());
		return user;
	}
	
	private Utilisateur castToDB(UtilisateurDTORest user) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(user.getId());
		utilisateur.setNom(user.getNom());
		utilisateur.setPrenom(user.getPrenom());
		utilisateur.setAdresse(user.getAdresse());
		utilisateur.setNaissance(user.getNaissance());
		return utilisateur;
	}

}
