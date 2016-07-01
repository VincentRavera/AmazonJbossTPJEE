package fr.treeptik.amazon.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import fr.treeptik.amazon.dto.rest.CommandeDTOWS;
import fr.treeptik.amazon.model.Commande;
import fr.treeptik.amazon.service.CommandeService;

@WebService
public class CommandeWS {
	@EJB
	private CommandeService commandeService;
	
	@WebMethod
	public CommandeDTOWS saveCommandWS(CommandeDTOWS com){
		Commande commande = this.castToDB(com);
		commande = commandeService.save(commande);
		com = this.extractFromDB(commande);
		return com;
	}
	
	@WebMethod
	public void removeCommandWS(CommandeDTOWS com) {
		Commande commande = this.castToDB(com);
		commandeService.remove(commande);
	}
	
	@WebMethod
	public CommandeDTOWS findByIdCommandWS(Integer id) {
		Commande commande = commandeService.findById(id);
		return this.extractFromDB(commande);
	}
	
	@WebMethod
	public List<CommandeDTOWS> findAllCommande() {
		List<Commande> commandes = commandeService.findAll();
		List<CommandeDTOWS> comms = new ArrayList<>();
		for (Commande commande : commandes) {
			comms.add(this.extractFromDB(commande));
		}
		return comms;
	}
	
	private CommandeDTOWS extractFromDB(Commande commande) {
		CommandeDTOWS com = new CommandeDTOWS();
		com.setId(commande.getId());
		com.setDateLivraison(commande.getDateLivraison());
		com.setDateCommande(commande.getDateLivraison());
		
		return com;
	}
	private Commande castToDB(CommandeDTOWS com) {
		Commande commande = new Commande();
		commande.setDateCommande(com.getDateCommande());
		commande.setDateLivraison(com.getDateLivraison());
		commande.setId(com.getId());
		return commande;
	}
	
}
