package web.clinic.dao;

import web.clinic.model.Role;

public interface RoleDao {
	Role getById(int id);
	void save(Role role);
	void delete(Role role);
	void update(Role role);
}
