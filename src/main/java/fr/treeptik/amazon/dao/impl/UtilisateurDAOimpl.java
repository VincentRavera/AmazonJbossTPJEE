package fr.treeptik.amazon.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.treeptik.amazon.dao.UtilisateurDAO;
import fr.treeptik.amazon.model.Utilisateur;

@Stateless
public class UtilisateurDAOimpl implements UtilisateurDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Utilisateur findById(Integer id) {
		return em.find(Utilisateur.class, id);
	}

	@Override
	public Utilisateur save(Utilisateur user) {
		if (user.getId() == null) {
			em.persist(user);
		} else {
			em.merge(user);
		}
		return user;
	}

	@Override
	public void remove(Utilisateur user) {
		em.remove(user);
	}

	@Override
	public List<Utilisateur> findAll() {
		return em.createQuery("SELECT u FROM Utilisateur u",Utilisateur.class).getResultList();
	}

}
