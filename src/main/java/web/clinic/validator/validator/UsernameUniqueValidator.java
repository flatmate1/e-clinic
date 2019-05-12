package web.clinic.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import web.clinic.service.UserService;



public class UsernameUniqueValidator implements ConstraintValidator<UsernameUnique, String> {
	
	@Autowired
	private UserService userService;

	public void initialize(UsernameUnique constraint) {
	}
	
	public boolean isValid(String username, ConstraintValidatorContext context) {
		return username != null && !userService.isUsernameAvailable(username);
		
	}

}
	
