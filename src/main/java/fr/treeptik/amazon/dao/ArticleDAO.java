package fr.treeptik.amazon.dao;

import java.util.List;

import fr.treeptik.amazon.model.Article;

public interface ArticleDAO {
	Article save(Article article);
	void remove(Article article);
	List<Article> findAll();
	Article findById(Integer id);
	List<Article> findByCommand(Integer id);

}
