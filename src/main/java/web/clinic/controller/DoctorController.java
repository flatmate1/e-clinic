package web.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.clinic.model.Doctor;
import web.clinic.model.ReservationDetails;
import web.clinic.service.DoctorService;

@Controller
public class DoctorController {
	
	private DoctorService doctorService;
	
	public DoctorController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	@GetMapping("/doctors")
	public String getAllDoctors(Model model) {
		model.addAttribute("doctors", doctorService.getAll());
		return "doctor";
		
	}
	
	@GetMapping("/doctors/add")
	public String addNewDoctor(Model model) {
		model.addAttribute("doctorForm", new Doctor());
		return "doctorForm";
	}
	
	@PostMapping("/doctors/add")
	public String addNewDoctorProcess(@ModelAttribute("doctorForm") Doctor doctor) {
		
		doctor.setAvailable(1);
		doctorService.save(doctor);
		
		return "redirect:/doctors";
	}
	
	@RequestMapping("/doctors/remove/{id}")
	public String deleteDoctor(@PathVariable(value="id") int id, Model model) {
		
		Doctor doctor;
		doctor = doctorService.getById(id);	
		doctorService.delete(doctor);
				
		return "redirect:/";
	}
	
}
