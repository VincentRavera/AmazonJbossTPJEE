package fr.treeptik.amazon.service;

import java.util.List;

import fr.treeptik.amazon.model.Utilisateur;

public interface UtilisateurService {
	Utilisateur findById(Integer id);
	Utilisateur save(Utilisateur user);
	void remove(Utilisateur user);
	List<Utilisateur> findAll();

}
