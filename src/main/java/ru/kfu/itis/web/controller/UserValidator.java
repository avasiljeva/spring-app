package ru.kfu.itis.web.controller;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ru.kfu.itis.domain.User;

@Component
public class UserValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if (!StringUtils.hasText(user.getFirstName())) {
			errors.rejectValue("firstName", "error.empty", "Empty first name!");
		}
		if (!StringUtils.hasText(user.getLastName())) {
			errors.rejectValue("lastName", "error.empty", "Empty last name!");
		}
	}
}
