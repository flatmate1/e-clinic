package web.clinic.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	  @GetMapping("/")
	  public String index(Model model, Authentication authentication) {
	    return "index";
	  }
	  @GetMapping("/logout")
	  public String logout(Model model, Principal principal) {
		  model.addAttribute("message", "You are loggout in as " + principal.getName());
		return "index";
		  
	  }
	  @GetMapping("/test")
	  public String test(Model model, Principal principal) {
	    model.addAttribute("message", "You are logged in as " + principal.getName());
	    return "test";
	  }
}
