package fr.treeptik.amazon.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import fr.treeptik.amazon.dao.CommandeDAO;
import fr.treeptik.amazon.exception.DAOException;
import fr.treeptik.amazon.model.Commande;

@Stateless
public class CommandeDAOImpl implements CommandeDAO {
	
	@PersistenceContext
	private EntityManager em;
//

	@Override
	public Commande save(Commande com) throws DAOException{
		try {
			if (com.getId() == null) {
				em.persist(com);
			} else {
				em.merge(com);
			}
			return com;
		} catch (PersistenceException e) {
			throw new DAOException("CommandeDAO save" + e.getMessage(), e);
		}
	}

	@Override
	public void delete(Commande com) throws DAOException{
		try {
			em.remove(com);
		} catch (PersistenceException e) {
			throw new DAOException("CommandeDAO delete" + e.getMessage(), e);
		}
		
	}

	@Override
	public Commande findById(Integer id) throws DAOException{
		try {
			return em.find(Commande.class, id);
		} catch (PersistenceException e) {
			throw new DAOException("CommandeDAO findById" + e.getMessage(), e);
		}
	}

	@Override
	public List<Commande> findall() throws DAOException{
		try {
			return em.createQuery("SELECT c FROM Commande c",Commande.class).getResultList();
		} catch (PersistenceException e) {
			throw new DAOException("CommandeDAO findall" + e.getMessage(), e);
		}
	}

}
