package web.clinic.dao;

import static org.junit.Assert.assertEquals;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MySQLContainer;

import web.clinic.config.DockerDatabase;
import web.clinic.config.TestAppConfig;
import web.clinic.dao.ReservationDao;
import web.clinic.model.Doctor;
import web.clinic.model.Reservation;
import web.clinic.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestAppConfig.class})
@ActiveProfiles("test")
@Transactional
public class ReservationDaoUnitTest extends DockerDatabase {
	
	private Reservation reservation;
	private Reservation reservation1;
	private User user;
	private Doctor doctor;
	
	@Autowired
	private ReservationDao reservationDao;
	
	@SuppressWarnings("rawtypes")
	@ClassRule
	public static MySQLContainer mysql() {
		return mysql;
	}
	
	@Test
	@Transactional
	public void Should_Save_Reservation_In_DB() {
		
		doctor = new Doctor();
		doctor.setAvailable(1);
		doctor.setName("test");
		doctor.setSpecialty("test");
		doctor.setSurname("test");
		doctor.setTitle("test");
		
		user = new User();
		user.setUsername("test");
		user.setPassword("$2a$10$z6.rY1y9j.4kkoZdOdbAxeZsfQvGMZvWxYH9Ny3vZrxHXcJtbS90.");
		
		reservation = new Reservation();
		reservation.setDoctor(doctor);
		reservation.setUser(user);

		reservationDao.save(reservation);
		
		assertEquals(user,reservationDao.getById(reservation.getId()).getUser());
		assertEquals(doctor, reservationDao.getById(reservation.getId()).getDoctor());
		assertEquals(reservation, reservationDao.getById(reservation.getId()));
	}

	@Test
	@Transactional
	public void Should_FindAll_Reservation() {
		
		doctor = new Doctor();
		doctor.setAvailable(1);
		doctor.setName("test");
		doctor.setSpecialty("test");
		doctor.setSurname("test");
		doctor.setTitle("test");
		
		user = new User();
		user.setUsername("test");
		user.setPassword("$2a$10$z6.rY1y9j.4kkoZdOdbAxeZsfQvGMZvWxYH9Ny3vZrxHXcJtbS90.");
		
		
		reservation1 = new Reservation();
		reservation1.setDoctor(doctor);
		reservation1.setUser(user);

		reservationDao.save(reservation1);
		
		assertEquals(1, reservationDao.getAll().size());
	}
	
	@Test
	@Transactional
	public void Should_FindAll_User_Reservation() {
				
		doctor = new Doctor();
		doctor.setAvailable(1);
		doctor.setName("test");
		doctor.setSpecialty("test");
		doctor.setSurname("test");
		doctor.setTitle("test");
		
		user = new User();
		user.setUsername("test");
		user.setPassword("$2a$10$z6.rY1y9j.4kkoZdOdbAxeZsfQvGMZvWxYH9Ny3vZrxHXcJtbS90.");
		
		reservation = new Reservation();
		reservation.setDoctor(doctor);
		reservation.setUser(user);

		reservationDao.save(reservation);
		
		reservation1 = new Reservation();
		reservation1.setDoctor(doctor);
		reservation1.setUser(user);

		reservationDao.save(reservation1);
		
		assertEquals(2, reservationDao.getUserReservation("test").size());
	}
	

}

