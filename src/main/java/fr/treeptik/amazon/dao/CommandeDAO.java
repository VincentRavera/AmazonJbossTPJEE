package fr.treeptik.amazon.dao;

import java.util.List;

import fr.treeptik.amazon.exception.DAOException;
import fr.treeptik.amazon.model.Commande;
// toto
public interface CommandeDAO {

	Commande save(Commande com) throws DAOException;

	void delete(Commande com) throws DAOException;

	Commande findById(Integer id) throws DAOException;

	List<Commande> findall() throws DAOException;

}
