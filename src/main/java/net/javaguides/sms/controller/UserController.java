package net.javaguides.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import antlr.collections.List;
import net.javaguides.sms.entity.Course;
import net.javaguides.sms.entity.User;
import net.javaguides.sms.repository.StudentCourseRepository;
import net.javaguides.sms.repository.UserRepository;
import net.javaguides.sms.service.CourseService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private StudentCourseRepository courseRepository;
	
	// handler method to home page and return mode and view
	@GetMapping("/index")
	public String viewHomePage() {
		return "index";
	}
	
	// create new account object to hold account form data
	@GetMapping("/create_account")
	public String showRegisterForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "create_account";
	}
	
	//post and save the new added user
	@PostMapping("/process_register")
	public String saveUser(User user) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String encodedPassword = encoder.encode(user.getPassword());
//		user.setPassword(encodedPassword);
		
		userRepository.save(user);
		
		return "account_created"; 
	}
	
	@GetMapping("/list_courses")
	public String viewCoursesList(Model model) {
		model.addAttribute("course", courseService.getAllCourses());
		return "course";
	}
}