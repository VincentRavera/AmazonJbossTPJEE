package fr.treeptik.amazon.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import fr.treeptik.amazon.dao.UtilisateurDAO;
import fr.treeptik.amazon.model.Utilisateur;
import fr.treeptik.amazon.service.UtilisateurService;

@Stateless
public class UtilisateurServiceImpl implements UtilisateurService {
	
	@EJB
	private UtilisateurDAO userDAO;

	@Override
	public Utilisateur findById(Integer id) {
		return userDAO.findById(id);
	}

	@Override
	@Transactional
	public Utilisateur save(Utilisateur user) {
		return userDAO.save(user);
	}

	@Override
	@Transactional
	public void remove(Utilisateur user) {
		user = this.findById(user.getId());
		userDAO.remove(user);
		
	}

	@Override
	public List<Utilisateur> findAll() {
		return userDAO.findAll();
	}

}
