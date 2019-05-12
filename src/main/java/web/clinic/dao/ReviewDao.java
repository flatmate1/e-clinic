package web.clinic.dao;

import java.util.List;

import web.clinic.model.Review;

public interface ReviewDao {
	Review getById(int id);
	void save(Review review);
	List<Review> getReviewByDoctorId(int id);
	List<Review> getReviewByUserId(String username);
	

}
