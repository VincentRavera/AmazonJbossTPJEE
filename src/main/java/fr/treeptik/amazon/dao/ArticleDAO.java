package fr.treeptik.amazon.dao;

import java.util.List;

import fr.treeptik.amazon.exception.DAOException;
import fr.treeptik.amazon.model.Article;

public interface ArticleDAO {
	Article save(Article article) throws DAOException;
	void remove(Article article) throws DAOException;
	List<Article> findAll() throws DAOException;
	Article findById(Integer id) throws DAOException;
	List<Article> findByCommand(Integer id) throws DAOException;

}
