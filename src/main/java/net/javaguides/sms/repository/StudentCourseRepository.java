package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//Primary key

import net.javaguides.sms.entity.Course;
import net.javaguides.sms.entity.User;

public interface StudentCourseRepository extends JpaRepository<Course, Long>{

}
