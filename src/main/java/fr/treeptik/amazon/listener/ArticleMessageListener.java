package fr.treeptik.amazon.listener;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;

import fr.treeptik.amazon.dao.ArticleDAO;
import fr.treeptik.amazon.exception.DAOException;
import fr.treeptik.amazon.exception.ServiceException;
import fr.treeptik.amazon.model.Article;
import fr.treeptik.amazon.model.Cd;
import fr.treeptik.amazon.model.Dvd;
import fr.treeptik.amazon.model.Livre;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/AmazonArticleQueue") })
public class ArticleMessageListener implements MessageListener {

	private Logger logger = Logger.getLogger(ArticleMessageListener.class);
	
	@EJB
	private ArticleDAO articleDAO;
	
	@Override
	@Transactional
	public void onMessage(Message message) throws ServiceException{
		ObjectMessage msg = (ObjectMessage) message;
		logger.info("Received Article Adding to DataBase");
		Article article = null;
		try {
			article = (Article) msg.getObject();
			if (article instanceof Livre){
				Livre livre = (Livre) article;
				articleDAO.save(livre);
			}
			if (article instanceof Cd) {
				Cd cd = (Cd) article;
				articleDAO.save(cd);
			}
			if (article instanceof Dvd) {
				Dvd dvd = (Dvd) article;
				articleDAO.save(dvd);
			}
			else {
				logger.info("BZZZZZZZZZZZZZ :( ");
				articleDAO.save(article);
			}
			logger.info("Article saved");
		} catch (JMSException | DAOException e) {
			logger.info("Non Valid Object Received");
			throw new ServiceException("ArticleMessageListener onMessage"+e.getMessage(), e);
		}
		
		
	}

}
