package web.clinic.dao;

import static org.junit.Assert.assertEquals;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MySQLContainer;

import web.clinic.config.DockerDatabase;
import web.clinic.config.TestAppConfig;
import web.clinic.dao.ReviewDao;
import web.clinic.model.Doctor;
import web.clinic.model.Review;
import web.clinic.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestAppConfig.class})
@ActiveProfiles("test")
@Transactional
@Rollback(false)
public class ReviewDaoUnitTest extends DockerDatabase {

	private Review review;
	private Doctor doctor;
	private User user;
	
	@Autowired
	private ReviewDao reviewDao;

	@SuppressWarnings("rawtypes")
	@ClassRule
	public static MySQLContainer mysql() {
		return mysql;
	}
	
	@Test
	@Transactional
	public void Should_Save_Review_In_DB() {
		user = new User();
		user.setUsername("test");
		user.setPassword("$2a$10$z6.rY1y9j.4kkoZdOdbAxeZsfQvGMZvWxYH9Ny3vZrxHXcJtbS90.");
		
		doctor = new Doctor();
		doctor.setAvailable(1);
		doctor.setName("test");
		doctor.setSpecialty("test");
		doctor.setSurname("test");
		doctor.setTitle("test");
		
		review = new Review();
		review.setComment("test");
		review.setRating(5);
		review.setDoctor(doctor);
		review.setUser(user);
		
		reviewDao.save(review);
	
		assertEquals(review, reviewDao.getById(review.getId()));
	}
	
	@Test
	@Transactional
	public void Should_Return_Review_By_UserId() {
		user = new User();
		user.setUsername("test");
		user.setPassword("$2a$10$z6.rY1y9j.4kkoZdOdbAxeZsfQvGMZvWxYH9Ny3vZrxHXcJtbS90.");
		
		doctor = new Doctor();
		doctor.setAvailable(1);
		doctor.setName("test");
		doctor.setSpecialty("test");
		doctor.setSurname("test");
		doctor.setTitle("test");
		
		review = new Review();
		review.setComment("test");
		review.setRating(5);
		review.setDoctor(doctor);
		review.setUser(user);
		
		reviewDao.save(review);
		
		assertEquals(review, reviewDao.getReviewByUserId("test").get(0));
		assertEquals(1, reviewDao.getReviewByUserId("test").size());
	}
	
	@Test
	@Transactional
	public void Should_Return_Review_By_DoctorId() {
		user = new User();
		user.setUsername("test");
		user.setPassword("$2a$10$z6.rY1y9j.4kkoZdOdbAxeZsfQvGMZvWxYH9Ny3vZrxHXcJtbS90.");
		
		doctor = new Doctor();
		doctor.setAvailable(1);
		doctor.setName("test");
		doctor.setSpecialty("test");
		doctor.setSurname("test");
		doctor.setTitle("test");
		
		review = new Review();
		review.setComment("test");
		review.setRating(5);
		review.setDoctor(doctor);
		review.setUser(user);
		
		reviewDao.save(review);
		
		assertEquals(review, reviewDao.getReviewByDoctorId(doctor.getId()).get(0));
		assertEquals(1, reviewDao.getReviewByDoctorId(doctor.getId()).size());
	}
	
	
}
