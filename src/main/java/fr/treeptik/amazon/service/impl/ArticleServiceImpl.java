package fr.treeptik.amazon.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.transaction.Transactional;

import fr.treeptik.amazon.dao.ArticleDAO;
import fr.treeptik.amazon.exception.DAOException;
import fr.treeptik.amazon.exception.ServiceException;
import fr.treeptik.amazon.model.Article;
import fr.treeptik.amazon.service.ArticleService;

@Stateless
public class ArticleServiceImpl implements ArticleService {

	@EJB
	private ArticleDAO articleDAO;

	@Resource(mappedName = "java:/jms/AmazonArticleQueue")
	private Queue queue;

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Override
	public Article save(Article article) {
		Connection connection = null;
		try {
			connection = connectionFactory.createConnection();
			Session session = connection.createSession();
			MessageProducer producer = session.createProducer(queue);
			ObjectMessage objectMessage = session.createObjectMessage();
			objectMessage.setObject(article);
			producer.send(objectMessage);
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (NullPointerException | JMSException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	@Transactional
	public void remove(Article article) throws ServiceException {
		try {
			article = this.findById(article.getId());
			articleDAO.remove(article);
		} catch (DAOException e) {
			throw new ServiceException("ArticleService remove()" + e.getMessage(), e);
		}
	}

	@Override
	public List<Article> findAll() throws ServiceException {
		try {
			return articleDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("ArticleService findAll" + e.getMessage(), e);
		}
	}

	@Override
	public Article findById(Integer id) throws ServiceException {
		try {
			return articleDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException("ArticleService findById" + e.getMessage(), e);
		}
	}

	@Override
	public List<Article> findByCommand(Integer id) throws ServiceException {
		try {
			return articleDAO.findByCommand(id);
		} catch (DAOException e) {
			throw new ServiceException("ArticleService findByCommand"+e.getMessage(), e);
		}
	}

}
