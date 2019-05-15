package web.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import web.clinic.model.Doctor;
import web.clinic.model.Reservation;
import web.clinic.model.ReservationDetails;
import web.clinic.model.Review;
import web.clinic.model.User;
import web.clinic.service.DoctorService;
import web.clinic.service.MailService;
import web.clinic.service.ReservationService;
import web.clinic.service.ReviewService;
import web.clinic.service.UserService;

@Controller
public class ReservationController {
	private ReservationService reservationService;
	private UserService userService;
	private DoctorService doctorService;
	private ReviewService reviewService;
	private MailService mailService;

	@Autowired
	public ReservationController(ReservationService reservationService,  UserService userService, 
								 DoctorService doctorService, ReviewService reviewService,
								 MailService mailService) {
		
		this.reservationService = reservationService;
		this.userService = userService;
		this.doctorService = doctorService;
		this.reviewService = reviewService;
		this.mailService = mailService;
	}
	
	@GetMapping("/reservation/doctor/{id}")
	public String showForm(@PathVariable(value="id") int id, Model model) {
		model.addAttribute("reservationForm", new ReservationDetails());
		
		if((doctorService.getById(id)).getAvailable() == 1) {
			return "reservationdetails";
		} else {
			
			// should show error page
	
			return "redirect:/";
		}
	}
	
	@PostMapping("/reservation/doctor/{id}")
	public String makeReservation(@PathVariable(value="id") int id, 
								  @ModelAttribute("reservationForm") ReservationDetails reservationDetails, 
								  Authentication authentication) {
		Doctor doctor;
	    doctor = doctorService.getById(id);
	    doctor.setAvailable(0);
	    doctorService.update(doctor);
		
	    User user ;
		user = userService.getByUsername(authentication.getName());
		
		Reservation res = new Reservation();
		res.setDoctor(doctor);
		res.setUser(user);
		
		reservationDetails.setUser(user);
		reservationService.save(res);
	
		mailService.sendSimpleMessage(user.getMail(), "You've booked a visit", 
				"You have an appointment with a " + doctor.getTitle() + " " + doctor.getName() 
				+ " " + doctor.getSurname());
		
		return "redirect:/";
	}
	
	@GetMapping("/reservation/doctor/{id}/finish")
	public String showFinishReservationForm(@PathVariable(value="id") int id, Model model) {
		
		// check if user has reservation with DOCTOR_ID
		
		// if userReservation(username, doctor_id) has d doctor_id having doctor_id
		
		model.addAttribute("reviewForm", new Review());
		return "finishForm";
	}
	
	@PostMapping("/reservation/doctor/{id}/finish")
	public String FinishReservation(@PathVariable(value="id") int id, Model model,
			 @ModelAttribute("reviewForm") Review review,
			 Authentication auth) {
	
		Doctor doctor;
		doctor = doctorService.getById(id);	
		doctor.setAvailable(1);
		doctorService.update(doctor);
		System.out.println(doctor.getAvailable());
		review.setDoctor(doctor);
		doctorService.update(doctor);
		reviewService.save(review);
		
		return "redirect:/";
	}
}
