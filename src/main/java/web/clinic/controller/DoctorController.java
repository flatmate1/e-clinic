package web.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import web.clinic.model.Doctor;
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
		
		doctorService.save(doctor);
		
		return "redirect:/doctors";
		
	}

}
