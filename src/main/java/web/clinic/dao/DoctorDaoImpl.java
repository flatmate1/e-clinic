package web.clinic.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import web.clinic.model.Doctor;

@Repository
public class DoctorDaoImpl implements DoctorDao {
	private SessionFactory sessionFactory;
	
	public DoctorDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(Doctor doctor) {
		getSession().save(doctor);
	}
	
	public void update(Doctor doctor) {
		getSession().update(doctor);
	}
	
	public Doctor getById(int id) {
		return getSession().get(Doctor.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Doctor> getAll() {
		List<Doctor> doctor = getSession()
				.createQuery("from Doctor")
				.list();
		return doctor;
	}

	public void delete(Doctor doctor) {
		getSession().delete(doctor);
		
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
