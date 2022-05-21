package com.management.college.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name="person")
public class Person {

    // primary key of an entity
	@Id
	
	 // @GeneratedValue annotation Provides for the
    // specification of generation strategies
    // for the values of primary keys
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	
	// @Column annotation specifies
    // the name of the column
	@Column ( name = "name", nullable = false)
	private String name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;
	
	@Column (name= "number", nullable=false)
	private String number;
	
	@Column (name= "gender", nullable=false)
	private String gender;

	@Column (name="email", nullable = false)
	private String email;
	
	
	@Column (name="userid", nullable = false)
	@OneToOne 
	@JoinTable (name= "users", joinColumns =@JoinColumn(name="id") )
	private String userid;
	
	

	public Person(String username, String password, String name, Date birth, String number, String gender,
			String email, boolean enabled, Set<Role> roles) {
		super();
		this.name = name;
		this.birth = birth;
		this.number = number;
		this.gender = gender;
		this.email = email;
		
	}

	public Person() {
		super();
		System.out.println("has been created !");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	}

	
	
	

