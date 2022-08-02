package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Course;
import net.javaguides.sms.repository.StudentCourseRepository;
import net.javaguides.sms.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	private StudentCourseRepository courseRepository;
	
	
	public CourseServiceImpl(StudentCourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}
	
	@Override
	public List<Course> getAllCourses(){
		// return a list of courses
		return courseRepository.findAll();
	}

	@Override
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course getCourseById(Long id) {
		return courseRepository.findById(id).get();
	}

	@Override
	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public void deleteCourseById(Long id) {
		courseRepository.deleteById(id);
	}
}
