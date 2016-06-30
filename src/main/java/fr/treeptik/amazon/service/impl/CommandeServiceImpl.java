package fr.treeptik.amazon.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;

import fr.treeptik.amazon.dao.CommandeDAO;
import fr.treeptik.amazon.exception.DAOException;
import fr.treeptik.amazon.exception.ServiceException;
import fr.treeptik.amazon.model.Commande;
import fr.treeptik.amazon.service.CommandeService;
import fr.treeptik.amazon.service.UtilisateurService;

@Stateless
public class CommandeServiceImpl implements CommandeService {

	Logger log = Logger.getLogger(CommandeServiceImpl.class);

	@EJB
	private CommandeDAO commandeDAO;

	@EJB
	private UtilisateurService utilisateurService;

	@Transactional
	@Override
	public Commande save(Commande com) throws ServiceException {
		try {
			return commandeDAO.save(com);
		} catch (DAOException e) {
			throw new ServiceException("CommandeService save" + e.getMessage(), e);
		}
	}

	@Transactional
	@Override
	public void remove(Commande com) throws ServiceException {
		try {
			com = this.findById(com.getId());
			commandeDAO.delete(com);
		} catch (DAOException e) {
			throw new ServiceException("CommandeService remove" + e.getMessage(), e);
		}

	}

	@Override
	public Commande findById(Integer id) throws ServiceException {
		try {
			return commandeDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException("CommandeService findById" + e.getMessage(), e);
		}
	}

	@Override
	public List<Commande> findAll() throws ServiceException {
		try {
			return commandeDAO.findall();
		} catch (DAOException e) {
			throw new ServiceException("CommandeService findAll" + e.getMessage(), e);
		}
	}

}
