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
import web.clinic.dao.UserDao;
import web.clinic.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestAppConfig.class})
@ActiveProfiles("test")
@Transactional
@Rollback(false)
public class UserDaoUnitTest extends DockerDatabase {	
	
	private User user;
	
	@Autowired
	private UserDao userDao;
	
	@SuppressWarnings("rawtypes")
	@ClassRule
	public static MySQLContainer mysql() {
		return mysql;
	}
	

	@Test
	@Transactional
	public void Should_Save_User_In_DB() {
		user = new User();
		user.setUsername("test");
		user.setPassword("$2a$10$z6.rY1y9j.4kkoZdOdbAxeZsfQvGMZvWxYH9Ny3vZrxHXcJtbS90.");
		userDao.save(user);
		
		assertEquals(userDao.getByUsername("test").getUsername(), user.getUsername());
		assertEquals(userDao.getByUsername("test").getPassword(), user.getPassword());
	}
	
	@Test
	@Transactional
	public void Should_Update_Password_Field_In_DB() {
		user = userDao.getByUsername("test");
		user.setPassword("$2a$10$pEsyxzG67E8M1RZ6KeM4POGO3Y4DWZXO8s8DUkFxJ.wCve73XM6aq");
		userDao.update(user);
		
		assertEquals(userDao.getByUsername("test").getPassword(), user.getPassword());
	}
	
}

	

