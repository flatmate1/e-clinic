package web.clinic.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.clinic.dao.ReviewDao;
import web.clinic.model.Review;


@Service
public class ReviewServiceImpl implements ReviewService {
	private ReviewDao reviewDao;
	
	public ReviewServiceImpl(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	
	@Transactional
	public void save(Review review) {
		reviewDao.save(review);
	}
	
	@Transactional(readOnly = true)
	public List<Review> getReviewByDoctorId(int id) {
		return reviewDao.getReviewByDoctorId(id);
	}
	
	@Transactional(readOnly = true)
	public List<Review> getReviewByUserId(String username) {
		return reviewDao.getReviewByUserId(username);
	}

}
