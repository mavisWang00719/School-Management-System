package net.javaguides.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Course;
import net.javaguides.sms.repository.StudentCourseRepository;
import net.javaguides.sms.repository.UserRepository;
import net.javaguides.sms.service.CourseService;
@Controller
public class CourceController {
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private CourseRepository courseRepository;
	
	@Autowired
	private CourseService courseService;
	

	public CourceController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	// handler method to handle list courses and return mode and view
	@GetMapping("/course")
	public String viewCoursePage(Model model) {
		model.addAttribute("course", courseService.getAllCourses());
		return "course";
	}
	
	// create new course object
	@GetMapping("/course/new")
	public String createCourseForm(Model model) {
		Course course = new Course();
		model.addAttribute("course", course);
		return "add_course";
	}
	
	//post and save the new added course
	@PostMapping("/course")
	public String saveCourse(@ModelAttribute("course") Course course) {
		courseService.saveCourse(course);
		return "redirect:/course";
				//redirect to the first course block
	}

	@GetMapping("/course/edit/{id}")
	public String editCourseForm(@PathVariable Long id, Model model ) {
		model.addAttribute("course", courseService.getCourseById(id));
		return "edit_course";
	}
	
	@PostMapping("/course/{id}")
	public String updateCourse(@PathVariable Long id,
			@ModelAttribute("course") Course course,
			Model model) {
		
		// get course from database by id
		Course existingCourse = courseService.getCourseById(id);
		existingCourse.setId(id);
		existingCourse.setCourseTime(course.getCourseTime());
		existingCourse.setCourseTeacher(course.getCourseTeacher());
		existingCourse.setCourseDuration(course.getCourseDuration());
		existingCourse.setCourseGrade(course.getCourseGrade());
		
		// save updated course object
		courseService.updateCourse(existingCourse);
		return "redirect:/course";		
	}
	
	@GetMapping("/course/{id}")
	// handler method to handle delete course request
	public String deleteCourse(@PathVariable Long id) {
		courseService.deleteCourseById(id);
		return "redirect:/course";
	}
	
}
