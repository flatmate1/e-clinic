package web.clinic.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import web.clinic.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(User user) {
		getSession().save(user);
	}
	
	public User getByUsername(String username) {
		User user;
		
		try {
			
			user = (User) getSession()
				.createQuery("from User u where u.username=:username")
				.setParameter("username", username)
				.getSingleResult();
		
		} catch (NoResultException e) {
			user = null;
			
		}
		
		return user;
	}
	
	public void update(User user) {
		getSession().update(user);
	}
	
	public void delete(User user) {
		getSession().delete(user);
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
