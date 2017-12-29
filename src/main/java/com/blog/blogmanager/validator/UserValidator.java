package com.blog.blogmanager.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.blog.blogmanager.domain.User;
import com.blog.blogmanager.service.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object object, Errors errors) {
	
		User user = (User) object;
		
		//username
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if(user.getUsername().length() < 6 || user.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}
		
		if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

		//password
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        
        if(!user.getPasswordConfirm().equals(user.getPassword())) {
        	errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
        
        //email
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");  
        if (!user.getEmail().contains("@")) {
            errors.rejectValue("email", "NoAtrate.userForm.email");
        }
        
        //firstname
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty");
       
        //lastname
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "NotEmpty");
                       	
	}

}
