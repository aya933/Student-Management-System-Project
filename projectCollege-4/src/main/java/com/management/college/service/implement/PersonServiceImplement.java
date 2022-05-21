package com.management.college.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.management.college.entity.Person;
import com.management.college.repository.PersonRepository;
import com.management.college.services.PersonService;

@Service
public class PersonServiceImplement implements PersonService {
	
	private PersonRepository personRepository;
	

	public PersonServiceImplement(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	@Override
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	@Override
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person getPersonById(Long id) {
		return personRepository.findById(id).get();
	}

	@Override
	public Person updatePerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void deletePersonById(Long id) {
		personRepository.deleteById(id);
		
	}

}
