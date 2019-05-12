package web.clinic.service;

import java.util.List;

import web.clinic.model.Review;

public interface ReviewService {
	void save(Review review);
	List<Review> getReviewByDoctorId(int id);
	List<Review> getReviewByUserId(String username); 
	
	
}
