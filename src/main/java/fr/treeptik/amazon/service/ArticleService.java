package fr.treeptik.amazon.service;

import java.util.List;

import fr.treeptik.amazon.exception.ServiceException;
import fr.treeptik.amazon.model.Article;

public interface ArticleService {
	Article save(Article article) throws ServiceException;
	void remove(Article article) throws ServiceException;
	List<Article> findAll() throws ServiceException;
	Article findById(Integer id) throws ServiceException;
	List<Article> findByCommand(Integer id) throws ServiceException;

}
