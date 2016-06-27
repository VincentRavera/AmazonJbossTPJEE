package fr.treeptik.amazon.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.treeptik.amazon.dao.CommandeDAO;
import fr.treeptik.amazon.model.Commande;

@Stateless
public class CommandeDAOImpl implements CommandeDAO {
	
	@PersistenceContext
	private EntityManager em;
//

	@Override
	public Commande save(Commande com) {
		if (com.getId() == null) {
			em.persist(com);
		} else {
			em.merge(com);
		}
		return com;
	}

	@Override
	public void delete(Commande com) {
		em.remove(com);
		
	}

	@Override
	public Commande findById(Integer id) {
		return em.find(Commande.class, id);
	}

	@Override
	public List<Commande> findall() {
		return em.createQuery("SELECT c FROM Commande c",Commande.class).getResultList();
	}

}
