package web.clinic.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import web.clinic.model.Reservation;
import web.clinic.service.ReservationService;

@Controller
public class UserController {
	
	
	ReservationService reservationService;
	
	public UserController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@GetMapping("/myreservation")
	public String showMyReservation(Model model, Authentication authentication) {
		List<Reservation> reservation = reservationService
				.getUserReservation(authentication.getName());
		
		model.addAttribute("reservationInfoObject", reservation);		
		return "myreservation";
	}

}
