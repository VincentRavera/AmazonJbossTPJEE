package fr.treeptik.amazon.dao;

import java.util.List;

import fr.treeptik.amazon.exception.DAOException;
import fr.treeptik.amazon.model.Utilisateur;

public interface UtilisateurDAO {
	Utilisateur findById(Integer id) throws DAOException;
	Utilisateur save(Utilisateur user) throws DAOException;
	void remove(Utilisateur user) throws DAOException;
	List<Utilisateur> findAll() throws DAOException;

}
