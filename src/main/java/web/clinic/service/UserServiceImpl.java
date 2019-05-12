package web.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.clinic.dao.UserDao;
import web.clinic.model.User;

@Service
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}

	@Transactional
	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.save(user);
	}

	@Transactional(readOnly = true)
	public User getByUsername(String username) {
		return userDao.getByUsername(username);
	}

	@Transactional(readOnly = true)
	public boolean isUsernameAvailable(String username) {
		boolean userInDb = true;
		return userDao.getByUsername(username) == null ? userInDb = false: userInDb;
	}
	
}
