package ru.kfu.itis.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.kfu.itis.domain.User;
import ru.kfu.itis.interfaces.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UserService userService;	

	@Autowired 
	private UserValidator validator;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView displayUsers() {
		ModelAndView mav = new ModelAndView("users");

		// load users
		List<User> users = userService.getUsers();
		mav.addObject("users", users); 

		// empty command object for a form
		mav.addObject("user", new User());

		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addUser(Model model, 
			@ModelAttribute User user, BindingResult result){

		validator.validate(user, result);
		if (result.hasErrors()) {
			// we'd like to display users anyway
			model.addAttribute("users", userService.getUsers());
			return "users";
		}
		userService.addUser(user);
		return "redirect:users";
	}
}
