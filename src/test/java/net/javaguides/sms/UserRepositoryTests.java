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
import net.javaguides.sms.entity.User;
import net.javaguides.sms.repository.StudentCourseRepository;
import net.javaguides.sms.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	 private UserRepository userRepository;
	
	@Autowired
	 private StudentCourseRepository courseRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("yuyang@gmail.com");
		user.setFirstName("yuyang");
		user.setLastName("He");
		user.setPassword("111");
		
		User savedUser = userRepository.save(user);
		
		User existUser = entityManager.find(User.class, savedUser.getEmail());
		
		assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
		Course course = new Course("10:00 - 12:00", "He", "120 min", "A");
		courseRepository.save(course);

	}
	@Test
	//test if we find the email in user database so he can login
	public void testFindUserByEmail() {
		String email = "maviswang0719@gmail.com";
		
		User user = userRepository.findByEmail(email);
		
		assertThat(user).isNotNull();
	}
}
