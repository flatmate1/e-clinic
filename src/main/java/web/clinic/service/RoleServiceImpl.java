package web.clinic.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.clinic.dao.RoleDao;
import web.clinic.model.Role;

@Service
public class RoleServiceImpl implements RoleService {
	
	private RoleDao roleDao;
	
	public RoleServiceImpl(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Transactional
	public Role getById(int id) {
		return roleDao.getById(id);
	}

	@Transactional
	public void save(Role role) {
		roleDao.save(role);
	}

	@Transactional
	public void delete(Role role) {
		roleDao.delete(role);
	}

	@Transactional
	public void update(Role role) {
		roleDao.update(role);
	}
}
