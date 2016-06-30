package fr.treeptik.amazon.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import fr.treeptik.amazon.dao.UtilisateurDAO;
import fr.treeptik.amazon.exception.DAOException;
import fr.treeptik.amazon.model.Utilisateur;

@Stateless
public class UtilisateurDAOimpl implements UtilisateurDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Utilisateur findById(Integer id) throws DAOException{
		try {
			return em.find(Utilisateur.class, id);
		} catch (PersistenceException e) {
			throw new DAOException("UtilisateurDAO findById" + e.getMessage(), e);
		}
	}

	@Override
	public Utilisateur save(Utilisateur user) throws DAOException{
		try {
			if (user.getId() == null) {
				em.persist(user);
			} else {
				em.merge(user);
			}
			return user;
		} catch (PersistenceException e) {
			throw new DAOException("UtilisateurDAO save" + e.getMessage(), e);
		}
	}

	@Override
	public void remove(Utilisateur user) throws DAOException{
		try {
			em.remove(user);
		} catch (PersistenceException e) {
			throw new DAOException("UtilisateurDAO remove"+e.getMessage(), e);
		}
	}

	@Override
	public List<Utilisateur> findAll() throws DAOException{
		try {
			return em.createQuery("SELECT u FROM Utilisateur u",Utilisateur.class).getResultList();
		} catch (PersistenceException e) {
			throw new DAOException("UtilisateurDAO findAll"+e.getMessage(), e);
		}
	}

}
