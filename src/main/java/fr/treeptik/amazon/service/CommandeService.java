package fr.treeptik.amazon.service;

import java.util.List;

import fr.treeptik.amazon.exception.ServiceException;
import fr.treeptik.amazon.model.Commande;

public interface CommandeService {
	Commande save(Commande com) throws ServiceException;
	void remove(Commande com) throws ServiceException;
	Commande findById(Integer id) throws ServiceException;
	List<Commande> findAll() throws ServiceException;

}
