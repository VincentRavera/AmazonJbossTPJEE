package fr.treeptik.amazon.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import fr.treeptik.amazon.model.Commande;
import fr.treeptik.amazon.service.CommandeService;

@WebService
public class CommandeWS {
	@EJB
	private CommandeService commandeService;
	
	@WebMethod
	public Commande saveCommandWS(Commande com){
		return commandeService.save(com);
	}
	
	@WebMethod
	public void removeCommandWS(Commande com) {
		commandeService.remove(com);
	}
	
	@WebMethod
	public Commande findByIdCommandWS(Integer id) {
		return commandeService.findById(id);
	}
	
	@WebMethod
	public List<Commande> findAllCommande() {
		return commandeService.findAll();
	}
	
}
