package fr.treeptik.amazon.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;

import fr.treeptik.amazon.model.Article;
import fr.treeptik.amazon.model.Cd;
import fr.treeptik.amazon.model.Dvd;
import fr.treeptik.amazon.model.Livre;
import fr.treeptik.amazon.service.ArticleService;

@ManagedBean
@RequestScoped
public class ArticleManagedBean {

	@EJB
	private ArticleService articleService;
	
	private Article article = null;
	private Livre livre = new Livre();
	private Cd cd = new Cd();
	private Dvd dvd = new Dvd();

	ListDataModel<Article> articles = new ListDataModel<>();
	
	public String createArticle() {
		article = articleService.save(article);
		return "article-list";
	}
	public String createLivre() {
		article = articleService.save(livre);
		return "article-list";
	}
	
	public String addLivre() {
		article = new Livre();
		return "livre";
	}
	public String addCd() {
		article = new Cd();
		return "cd";
	}
	public String addDvd() {
		article = new Dvd();
		return "dvd";
	}
	public String removeArticle() {
		System.out.println("Del Del TEst");
		return "article-list";
	}

	public ListDataModel<Article> getArticles() {
		articles.setWrappedData(articleService.findAll());
		return articles;
	}

	public ListDataModel<Article> getArticles(Integer id) {
		articles.setWrappedData(articleService.findByCommand(id));
		return articles;
	}

	public void setArticles(ListDataModel<Article> articles) {
		this.articles = articles;
	}

	public Article getArticle() {
		return article;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Cd getCd() {
		return cd;
	}

	public void setCd(Cd cd) {
		this.cd = cd;
	}

	public Dvd getDvd() {
		return dvd;
	}

	public void setDvd(Dvd dvd) {
		this.dvd = dvd;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	

}