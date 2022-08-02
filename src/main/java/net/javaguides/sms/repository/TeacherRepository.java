package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.javaguides.sms.entity.Teacher;
//Primary key
import net.javaguides.sms.entity.User;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	User findByEmail(String email);
}
