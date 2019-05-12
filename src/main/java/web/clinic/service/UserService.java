package web.clinic.service;

import web.clinic.model.User;

public interface UserService {
	void save(User user);
	User getByUsername(String username);
	boolean isUsernameAvailable(String username);
}
