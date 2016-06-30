package fr.treeptik.amazon.ressources;

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
	public Utilisateur saveUtilisateur(Utilisateur user) {
		return userService.save(user);
	}
	
	@DELETE
	public void removeUtillisateur(Utilisateur user) {
		userService.remove(user);
	}
	
	@PUT
	public Utilisateur updateUtilisateur(Utilisateur user) {
		return userService.save(user);
	}
	
	@GET
	public List<Utilisateur> findAllUtilisateur() {
		return userService.findAll();
	}
	
	@GET
	@Path("{id}")
	public Utilisateur findByIdUtilisateur(@PathParam("id") Integer id) {
		return userService.findById(id);
	}
	

}
