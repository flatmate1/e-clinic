package web.clinic.service;

import java.util.List;

import web.clinic.model.Reservation;

public interface ReservationService {
	void save(Reservation reservation);
	void update(Reservation reservation);
	void delete(Reservation reservation);
	List<Reservation> getUserReservation(String username);
}
