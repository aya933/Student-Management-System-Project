package com.management.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.college.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
