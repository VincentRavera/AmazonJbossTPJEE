package fr.treeptik.amazon.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import fr.treeptik.amazon.dao.CommandeDAO;
import fr.treeptik.amazon.model.Commande;
import fr.treeptik.amazon.service.CommandeService;
import fr.treeptik.amazon.service.UtilisateurService;

@Stateless
public class CommandeServiceImpl implements CommandeService {
	
	@EJB
	private CommandeDAO commandeDAO;

	@EJB
	private UtilisateurService utilisateurService;
	
	@Transactional
	@Override
	public Commande save(Commande com) {
		if (com.getClient()!=null && com.getClient().getId()!=null) {
			com.setClient(utilisateurService.findById(com.getClient().getId()));
			System.out.println(com.getClient().getNom()+" - ID : "+com.getClient().getId());
		}
		return commandeDAO.save(com);
	}

	@Transactional
	@Override
	public void remove(Commande com) {
		com = this.findById(com.getId());
		commandeDAO.delete(com);
		
	}

	@Override
	public Commande findById(Integer id) {
		return commandeDAO.findById(id);
	}

	@Override
	public List<Commande> findAll() {
		return commandeDAO.findall();
	}

}
