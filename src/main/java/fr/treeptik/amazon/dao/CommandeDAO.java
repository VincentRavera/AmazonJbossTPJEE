package fr.treeptik.amazon.dao;

import java.util.List;

import fr.treeptik.amazon.model.Commande;

public interface CommandeDAO {

	Commande save(Commande com);

	void delete(Commande com);

	Commande findById(Integer id);

	List<Commande> findall();

}
