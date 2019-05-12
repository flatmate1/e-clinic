package web.clinic.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.clinic.dao.ReservationDao;
import web.clinic.model.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService {
	private ReservationDao reservationDao;
	
	public ReservationServiceImpl(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}
	
	@Transactional(readOnly = true) 
	public Reservation getById(int id) {
		return reservationDao.getById(id);
	}
	
	@Transactional 
	public void save(Reservation reservation) {
		reservationDao.save(reservation);
	}
	
	@Transactional
	public void update(Reservation reservation) {
		reservation.getDoctor().setAvailable(0);
		reservationDao.update(reservation);	
	}
	
	@Transactional(readOnly = true)
	public List<Reservation> getUserReservation(String username) {
		return reservationDao.getUserReservation(username);
	}
	
	@Transactional
	public void delete(Reservation reservation) {
		reservationDao.delete(reservation);
		
	}
}
