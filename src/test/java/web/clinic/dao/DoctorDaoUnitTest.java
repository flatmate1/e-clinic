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
import web.clinic.dao.DoctorDao;
import web.clinic.model.Doctor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestAppConfig.class})
@ActiveProfiles("test")
@Transactional
public class DoctorDaoUnitTest extends DockerDatabase {
	
	private Doctor doctor;
	private Doctor doctor1;
	
	@Autowired
	private DoctorDao doctorDao;
	
	@SuppressWarnings("rawtypes")
	@ClassRule
	public static MySQLContainer mysql() {
		return mysql;
	}
	
	@Test
	@Transactional
	public void Should_Save_Doctor_In_DB() {
		doctor = new Doctor();
		doctor.setAvailable(1);
		doctor.setName("test");
		doctor.setSpecialty("test");
		doctor.setSurname("test");
		doctor.setTitle("test");
		doctor.setName("test");
		doctor.setPhoneNumber("123456789");
		doctor.setDateOfBirth("1-1-1990");
		
		doctorDao.save(doctor);
		
		assertEquals(doctor.getName(), doctorDao.getById(doctor.getId()).getName());
		assertEquals(doctor.getSurname(),doctorDao.getById(doctor.getId()).getSurname());
		assertEquals(doctor.getSpecialty(), doctorDao.getById(doctor.getId()).getSpecialty());
		assertEquals(doctor.getTitle(), doctorDao.getById(doctor.getId()).getTitle());
		assertEquals(doctor.getAvailable(), doctorDao.getById(doctor.getId()).getAvailable());
	}
	
	@Test
	@Transactional
	public void Should_Update_Doctor_In_DB() {
		doctor = new Doctor();
		doctor.setAvailable(1);
		doctor.setName("test");
		doctor.setSpecialty("test");
		doctor.setSurname("test");
		doctor.setTitle("test");
		doctor.setName("test");
		doctor.setPhoneNumber("123456789");
		doctor.setDateOfBirth("1-1-1990");
		
		doctorDao.save(doctor);
		
		doctor.setAvailable(0);
		
		doctorDao.update(doctor);
		
		assertEquals(doctorDao.getById(doctor.getId()).getAvailable(), 0);
	}
	
	@Test
	@Transactional
	public void Should_Return_All_Doctors() {
		doctor1 = new Doctor();
		doctor1.setAvailable(1);
		doctor1.setName("test");
		doctor1.setSpecialty("test");
		doctor1.setSurname("test");
		doctor1.setTitle("test");
		doctor1.setName("test");
		doctor1.setPhoneNumber("123456789");
		doctor1.setDateOfBirth("1-1-1990");
		
		doctor = new Doctor();
		doctor.setAvailable(1);
		doctor.setName("test1");
		doctor.setSpecialty("test1");
		doctor.setSurname("test1");
		doctor.setTitle("test1");
		doctor.setName("test1");
		doctor.setPhoneNumber("123456789");
		doctor.setDateOfBirth("1-1-1990");
		
		doctorDao.save(doctor);
		doctorDao.save(doctor1);
		
		assertEquals(2 ,(doctorDao.getAll()).size());
		
	}
	
}
