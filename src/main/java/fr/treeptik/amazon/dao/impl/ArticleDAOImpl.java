package fr.treeptik.amazon.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.treeptik.amazon.dao.ArticleDAO;
import fr.treeptik.amazon.model.Article;

@Stateless
public class ArticleDAOImpl implements ArticleDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Article save(Article article) {
		if (article.getId() == null) {
			em.persist(article);
		} else {
			em.merge(article);
		}
		return article;
	}

	@Override
	public void remove(Article article) {
		em.remove(article);
	}

	@Override
	public List<Article> findAll() {
		return em.createQuery("SELECT a FROM Article a", Article.class).getResultList();
	}

	@Override
	public Article findById(Integer id) {
		return em.find(Article.class, id);
	}

	@Override
	public List<Article> findByCommand(Integer id) {
		TypedQuery<Article> query = em.createQuery(
				"SELECT DISTINCT a FROM Article JOIN Command c WHERE c.id=:id",
				Article.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

}
