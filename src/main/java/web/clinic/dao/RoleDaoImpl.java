package web.clinic.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import web.clinic.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	private SessionFactory sessionFactory;
	
	public RoleDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;	
	}

	public Role getById(int id) {
		return getSession().get(Role.class, id);
		
	}

	public void save(Role role) {
		getSession().save(role);
	}

	public void delete(Role role) {
		getSession().delete(role);
	}
	
	public void update(Role role) {
		getSession().delete(role);
		
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
