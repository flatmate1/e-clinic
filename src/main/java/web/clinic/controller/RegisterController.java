package web.clinic.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import web.clinic.model.Role;
import web.clinic.model.User;
import web.clinic.service.RoleService;
import web.clinic.service.UserService;

@Controller
public class RegisterController {
	private UserService userService;
	private RoleService roleService;

	public RegisterController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}
	
	@GetMapping("/register")
	public String RegisterForm(Model model) {
		model.addAttribute("userForm", new User());
		return "register";
		
	}
	
	@PostMapping("/register")
	public String RegisterProcess(@ModelAttribute("userForm") @Valid User user, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("error");
			return "register";
		} else {
			
		Role role = new Role();
		role.setRole("ROLE_USER");
		role.setUsername(user.getUsername());
		
		userService.save(user);
		roleService.save(role);
		}
		
		return "redirect:/";
	}
}
    
