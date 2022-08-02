package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.Course;

public interface CourseService {
	List<Course> getAllCourses();
	
	Course saveCourse(Course course);
	
	Course getCourseById(Long id);
	
	Course updateCourse(Course course);
	
	void  deleteCourseById(Long id);
}

