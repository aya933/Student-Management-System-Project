package com.management.college.services;

import java.util.List;


import com.management.college.entity.Person;

public interface PersonService {
	

	List<Person> getAllPersons();

	Person savePerson(Person person);

	Person getPersonById(Long id);

	Person updatePerson(Person person);

	void deletePersonById(Long id);

}
