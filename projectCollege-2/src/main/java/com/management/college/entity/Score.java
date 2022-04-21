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
@Table(name="Score")
public class Score {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long scoreid;
	
	@Column (name= "scoreSTATUS", nullable=false)
	private String scoreSTATUS;
	
	@Column (name = "scoreCONTENT", nullable=false )
	private int scoreCONTENT;
	
	
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

	public Score(String scoreSTATUS, int scoreCONTENT) {
		super();
		this.scoreSTATUS = scoreSTATUS;
		this.scoreCONTENT = scoreCONTENT;
	}

	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getScoreid() {
		return scoreid;
	}

	public void setScoreid(Long scoreid) {
		this.scoreid = scoreid;
	}

	public String getScoreSTATUS() {
		return scoreSTATUS;
	}

	public void setScoreSTATUS(String scoreSTATUS) {
		this.scoreSTATUS = scoreSTATUS;
	}

	public int getScoreCONTENT() {
		return scoreCONTENT;
	}

	public void setScoreCONTENT(int scoreCONTENT) {
		this.scoreCONTENT = scoreCONTENT;
	}
	
	
}
