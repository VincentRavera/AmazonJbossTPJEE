package fr.treeptik.amazon.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import fr.treeptik.amazon.dao.CommandeDAO;
import fr.treeptik.amazon.model.Commande;
import fr.treeptik.amazon.service.CommandeService;

@Stateless
public class CommandeServiceImpl implements CommandeService {
	
	@EJB
	private CommandeDAO commandeDAO;

	@Transactional
	@Override
	public Commande save(Commande com) {
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
