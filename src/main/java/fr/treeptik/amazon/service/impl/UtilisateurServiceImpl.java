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

import fr.treeptik.amazon.dao.UtilisateurDAO;
import fr.treeptik.amazon.exception.DAOException;
import fr.treeptik.amazon.exception.ServiceException;
import fr.treeptik.amazon.model.Utilisateur;
import fr.treeptik.amazon.service.UtilisateurService;

@Stateless
public class UtilisateurServiceImpl implements UtilisateurService {

	@Resource(mappedName = "java:/jms/AmazonQueue")
	private Queue queue;

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@EJB
	private UtilisateurDAO userDAO;

	@Override
	public Utilisateur findById(Integer id) throws ServiceException {
		try {
			return userDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException("UtilisateurService findById" + e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public Utilisateur save(Utilisateur user) throws ServiceException {
		try {
			return userDAO.save(user);
		} catch (DAOException e) {
			throw new ServiceException("UtilisateurService save" + e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public void remove(Utilisateur user) throws ServiceException {
		try {
			user = this.findById(user.getId());
			userDAO.remove(user);
		} catch (ServiceException e) {
			throw new ServiceException(
					"UtilisateurService remove>findById" + e.getMessage(), e);
		} catch (DAOException e) {
			throw new ServiceException(
					"UtilisateurService remove"+e.getMessage(), e);
		}

	}

	@Override
	public List<Utilisateur> findAll() throws ServiceException{
		try {
			return userDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException(
					"UtilisateurService findAll"+e.getMessage(), e);
		}
	}

	public void sendUser(Utilisateur utilisateur) {
		Connection connection = null;
		try {
			connection = connectionFactory.createConnection();
			Session session = connection.createSession();
			MessageProducer producer = session.createProducer(queue);
			ObjectMessage objectMessage = session.createObjectMessage();
			objectMessage.setObject(utilisateur);
			producer.send(objectMessage);
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (JMSException e1) {
				e1.printStackTrace();
			}
		}
	}

}
