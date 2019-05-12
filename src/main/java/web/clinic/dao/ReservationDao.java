package web.clinic.dao;

import java.util.List;

import web.clinic.model.Reservation;

public interface ReservationDao {
	List<Reservation> getAll();
	Reservation getById(int id);
	void save(Reservation reservation);
	void update(Reservation reservation);
	void delete(Reservation reservation);
	List<Reservation> getUserReservation(String username);
}
