package fr.treeptik.amazon.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.treeptik.amazon.dao.ArticleDAO;
import fr.treeptik.amazon.exception.DAOException;
import fr.treeptik.amazon.model.Article;

@Stateless
public class ArticleDAOImpl implements ArticleDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Article save(Article article) throws DAOException{
		try {
			if (article.getId() == null) {
				em.persist(article);
			} else {
				em.merge(article);
			}
			
		} catch (PersistenceException e) {
			throw new DAOException("ArticleDAO save()" + e.getMessage(), e);
		}
		return article;
	}

	@Override
	public void remove(Article article) throws DAOException {
		try {
			em.remove(article);
			
		} catch (PersistenceException e) {
			throw new DAOException("ArticleDAO remove()" + e.getMessage(), e);
		}
	}

	@Override
	public List<Article> findAll() throws DAOException{
		List<Article> articles = null;
		try {
			articles = em.createQuery("SELECT a FROM Article a", Article.class).getResultList();
			
		} catch (PersistenceException e) {
			throw new DAOException("ArticleDAO findAll()" + e.getMessage(), e);
		}
		return articles;
	}

	@Override
	public Article findById(Integer id) throws DAOException{
		try {
			return em.find(Article.class, id);
		} catch (PersistenceException e) {
			throw new DAOException("ArticleDAO findById" + e.getMessage(), e);
		}
	}

	@Override
	public List<Article> findByCommand(Integer id) throws DAOException {
		TypedQuery<Article> query;
		try {
			query = em.createQuery(
					"SELECT DISTINCT a FROM Article JOIN Command c WHERE c.id=:id",
					Article.class);
			query.setParameter("id", id);
		} catch (PersistenceException e) {
			throw new DAOException("ArticleDAO findByCommand()"+e.getMessage(), e);
		}
		return query.getResultList();
	}

}
