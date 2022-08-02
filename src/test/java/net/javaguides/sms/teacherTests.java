package net.javaguides.sms;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import net.javaguides.sms.entity.Teacher;
import net.javaguides.sms.repository.TeacherRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class teacherTests {
	
	@Autowired
	 private TeacherRepository teacherRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateTeacher() {
		Teacher teacher = new Teacher();
		teacher.setEmail("yu@gmail.com");
		teacher.setName("yu");
		teacher.setPassword("112");
		
		Teacher savedTeacher = teacherRepository.save(teacher);
		
		Teacher existTeacher = entityManager.find(Teacher.class, savedTeacher.getId());
		
		assertThat(teacher.getId()).isEqualTo(existTeacher.getId());

	}
}
