package web.clinic.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import web.clinic.model.Review;

@Repository
public class ReviewDaoImpl implements ReviewDao {
	private SessionFactory sessionFactory;
	
	public ReviewDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Review getById(int id) {
		return getSession().get(Review.class, id);
	}

	public void save(Review review) {
		getSession().save(review);
	}
	
	@SuppressWarnings("unchecked")
	public List<Review> getReviewByDoctorId(int id) {
		List<Review> review = (List<Review>) getSession()
				.createQuery("from Review r where r.doctor.id = :id")
				.setParameter("id", id)
				.list();
		return review;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Review> getReviewByUserId(String username) {
		List<Review> review = (List<Review>) getSession()
				.createQuery("from Review r where r.user.username = :username")
				.setParameter("username", username)
				.list();
		return review;
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
