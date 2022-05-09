package com.management.college.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


@Entity
@Table(name="CourseElement")
public class ElementCourse {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long elementcourseid;
	
	@Column ( name="elementNAME", nullable = false)
	private String elementcourseNAME;
	
	
	@Column (name="elementREQUIREMENTS", nullable= true)
	private int elementcourseREQUIREMENTS;
	
	@Column (name="elementPERCENTAGE", nullable= true)
	private int elementcoursePERCENTAGE;
	
	@Column (name="elementSCORE", nullable= true)
	private int elementcourseSCORE;


	public int getElementcourseREQUIREMENTS() {
		return elementcourseREQUIREMENTS;
	}

	public void setElementcourseREQUIREMENTS(int elementcourseREQUIREMENTS) {
		this.elementcourseREQUIREMENTS = elementcourseREQUIREMENTS;
	}

	public int getElementcoursePERCENTAGE() {
		return elementcoursePERCENTAGE;
	}

	public void setElementcoursePERCENTAGE(int elementcoursePERCENTAGE) {
		this.elementcoursePERCENTAGE = elementcoursePERCENTAGE;
	}


	@ManyToOne
	@JoinColumn(name = "teachername")
	private Teacher teacher;
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@ManyToOne
	@JoinColumn(name = "studentname")
	private Student student;

	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	@ManyToOne
	@JoinColumn(name = "courseid")
	private Course course;


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public ElementCourse(String elementcourseNAME, int elementcourseREQUIREMENTS, int elementcoursePERCENTAGE,
			int elementcourseSCORE, Student student, Teacher teacher, Course course) {
		super();
		this.elementcourseNAME = elementcourseNAME;
		this.elementcourseREQUIREMENTS = elementcourseREQUIREMENTS;
		this.elementcoursePERCENTAGE = elementcoursePERCENTAGE;
		this.elementcourseSCORE = elementcourseSCORE;
		this.teacher = teacher;
		this.course = course;
	}


	public ElementCourse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getElementcourseid() {
		return elementcourseid;
	}


	public void setElementcourseid(Long elementcourseid) {
		this.elementcourseid = elementcourseid;
	}


	public String getElementcourseNAME() {
		return elementcourseNAME;
	}


	public void setElementcourseNAME(String elementcourseNAME) {
		this.elementcourseNAME = elementcourseNAME;
	}

	public int getElementcourseSCORE() {
		return elementcourseREQUIREMENTS;
	}


	public void setElementcourseSCORE(int elementcourseSCORE) {
		this.elementcourseREQUIREMENTS = elementcourseSCORE;
	}



}
