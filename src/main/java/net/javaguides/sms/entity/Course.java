package net.javaguides.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")

public class Course {
	
	//add primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "time", nullable = false)
	private String courseTime;
	
	@Column(name = "teacher")
	private String courseTeacher;
	
	@Column(name = "duration")
	private String courseDuration;
	
	@Column(name = "grade")
	private String courseGrade;
	
	// create default entity
	public Course() {
		
	}
	
	public Course(String courseTime, String courseTeacher, String courseDuration, String courseGrade) {
		super();
		this.courseTime = courseTime;
		this.courseTeacher = courseTeacher;
		this.courseDuration = courseDuration;
		this.courseGrade = courseGrade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}

	public String getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String getCourseGrade() {
		return courseGrade;
	}

	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}
	
}
