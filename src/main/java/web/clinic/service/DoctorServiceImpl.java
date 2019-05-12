package web.clinic.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.clinic.dao.DoctorDao;
import web.clinic.model.Doctor;


@Service
public class DoctorServiceImpl implements DoctorService {
	private DoctorDao doctorDao;
	
	public DoctorServiceImpl(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
	}
	
	@Transactional(readOnly=true)
	public List<Doctor> getAll() {
		return doctorDao.getAll();
	}

	@Transactional
	public Doctor getById(int id) {
		return doctorDao.getById(id);
	}
	
	// value = 1 or 0
	@Transactional
	public void setDoctorAvailable(int id, int value) {
		Doctor doctor = getById(id);
		doctorDao.update(doctor);
	}
	
	@Transactional
	public void save(Doctor doctor) {
		doctorDao.save(doctor);
	}
	
	@Transactional
	public void update(Doctor doctor) {
		doctorDao.update(doctor);
	}
	
	@Transactional
	public void delete(Doctor doctor) {
		doctorDao.delete(doctor);
	}
}
