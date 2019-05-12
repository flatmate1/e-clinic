package web.clinic.dao;

import java.util.List;

import web.clinic.model.Doctor;


public interface DoctorDao {
	void save(Doctor doctor);
	void update(Doctor doctor);
	void delete(Doctor doctor);
	Doctor getById(int id);
	List<Doctor> getAll();
}
