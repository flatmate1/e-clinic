package web.clinic.service;

import web.clinic.model.Role;

public interface RoleService {
	Role getById(int id);
	void save(Role role);
	void delete(Role role);
	void update(Role role);
}
