package web.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import web.clinic.model.User;
import web.clinic.service.UserService;

@Controller
public class TestingController {
	
	private final UserService userService;
	
	public TestingController(UserService userService) {
		this.userService = userService;
	
	}
	
	@GetMapping("/testing")
	public String RegisterForm(Model model) {
		model.addAttribute("userForm", new User());
//		model.addAttribute("userDetailForm", new UserDetails());
		return "newtest";
		
	}
	
	@PostMapping("/testing")
	public String RegisterProcess(@ModelAttribute("userForm") User user, BindingResult userResul) {
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		userService.save(user);
		return "redirect:/login";
	}
}
