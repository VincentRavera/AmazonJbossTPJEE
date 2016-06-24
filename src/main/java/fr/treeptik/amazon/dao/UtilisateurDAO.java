package fr.treeptik.amazon.dao;

import java.util.List;

import fr.treeptik.amazon.model.Utilisateur;

public interface UtilisateurDAO {
	Utilisateur findById(Integer id);
	Utilisateur save(Utilisateur user);
	void remove(Utilisateur user);
	List<Utilisateur> findAll();

}
