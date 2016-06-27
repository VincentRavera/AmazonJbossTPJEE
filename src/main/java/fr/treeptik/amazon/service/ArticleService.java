package fr.treeptik.amazon.service;

import java.util.List;

import fr.treeptik.amazon.model.Article;

public interface ArticleService {
	Article save(Article article);
	void remove(Article article);
	List<Article> findAll();
	Article findById(Integer id);
	List<Article> findByCommand(Integer id);

}
