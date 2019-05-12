package web.clinic.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import web.clinic.model.Reservation;

@Repository
public class ReservationDaoImpl implements ReservationDao {
	private SessionFactory sessionFactory;

	public ReservationDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Reservation getById(int id) {
		return getSession().get(Reservation.class, id);
	}
	
	public void save(Reservation reservation) {
		getSession().save(reservation);
	}
	
	public void update(Reservation reservation) {
		getSession().update(reservation);
	}
	
	@SuppressWarnings("unchecked")
	public List<Reservation> getAll() {
		List<Reservation> reservation = getSession()
				.createQuery("from Reservation")
				.list();
		
		return reservation;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reservation> getUserReservation(String username) {
		List<Reservation> userReservation = getSession()
				.createQuery("from Reservation r where r.user.username=:username")
				.setParameter("username", username)
				.list();
	
		return userReservation;
	}

	public void delete(Reservation reservation) {
		getSession().delete(reservation);
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
}

