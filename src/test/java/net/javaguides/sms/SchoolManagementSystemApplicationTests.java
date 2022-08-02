//package net.javaguides.sms;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class StudentManagementSystemApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}
package net.javaguides.sms;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import net.javaguides.sms.entity.Course;
import net.javaguides.sms.repository.StudentCourseRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SchoolManagementSystemApplicationTests {
	
	@Autowired
	 private StudentCourseRepository courseRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateCourse() {
		Course course = new Course();
		course.setCourseTime("10:45-12:45");
		course.setCourseTeacher("Mavis");
		course.setCourseDuration("120 min");
		course.setCourseGrade("/");
		Course savedCourse = courseRepository.save(course);
		
		Course existCourse = entityManager.find(Course.class, savedCourse.getId());
		
		assertThat(course.getId()).isEqualTo(existCourse.getId());
	}
	
	@Test
	public void testupdatedCourse() {
		Course course = new Course();
		course.setCourseTime("10:45-12:45");
		course.setCourseTeacher("Mavis");
		course.setCourseDuration("120 min");
		course.setCourseGrade("/");
		Course savedCourse = courseRepository.save(course);
		
		// Course existCourse = entityManager.find(Course.class, savedCourse.getId());
		
		assertThat(savedCourse).isEqualTo(courseRepository.findAll());
	}
}
