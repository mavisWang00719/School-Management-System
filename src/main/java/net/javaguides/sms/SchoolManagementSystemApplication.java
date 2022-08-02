package net.javaguides.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.sms.entity.Course;
import net.javaguides.sms.repository.StudentCourseRepository;

@SpringBootApplication
public class SchoolManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentCourseRepository courseRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Student student1 = new Student("Mavis", "Wang", "maviswang0719@gmail.com");
//		studentRepository.save(student1);
//		
//		Student student2 = new Student("Sanjay", "Jadhav", "sanjay@gmail.com");
//		studentRepository.save(student2);
//		
//		Student student3 = new Student("tony", "stark", "tony@gmail.com");
//		studentRepository.save(student3);
	}

}
