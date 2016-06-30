package fr.treeptik.amazon.service;

import java.util.List;

import fr.treeptik.amazon.exception.ServiceException;
import fr.treeptik.amazon.model.Utilisateur;

public interface UtilisateurService {
	Utilisateur findById(Integer id) throws ServiceException;
	Utilisateur save(Utilisateur user) throws ServiceException;
	void remove(Utilisateur user) throws ServiceException;
	List<Utilisateur> findAll() throws ServiceException;

}
