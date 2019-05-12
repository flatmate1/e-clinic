package web.clinic.dao;

import web.clinic.model.User;

public interface UserDao {
	void save(User user);
	void update(User user);
	void delete(User user);
	User getByUsername(String username);
}
