package fr.treeptik.amazon.service;

import java.util.List;

import fr.treeptik.amazon.model.Commande;

public interface CommandeService {
	Commande save(Commande com);
	void remove(Commande com);
	Commande findById(Integer id);
	List<Commande> findAll();

}
