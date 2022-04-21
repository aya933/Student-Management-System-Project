package com.management.college.service.implement;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.management.college.entity.Student;
import com.management.college.repository.StudentRepository;
import com.management.college.services.StudentService;


//@Service annotation is used with classes
//that provide some business functionalities
@Service

public class StudentServiceImplement implements StudentService {
	
	private StudentRepository studentRepository;
	

	public StudentServiceImplement(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	
	@Override
	public List<Student> getAllStudents() {
	    return studentRepository.findAll();
	}
	
	@Override
	public Student saveStudent (Student student) {
	    return studentRepository.save(student);
	    
	}


	@Override
	public Student getStudentById(Long id) {
		 Optional < Student > optional = studentRepository.findById(id);
	        Student student = null;
	        if (optional.isPresent()) {
	            student = optional.get();
	        } else {
	            throw new RuntimeException(" EStudent not found for id :: " + id);
	        }
	        return student;
		
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}	
	
	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);	
	}


	@Override
	public Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.studentRepository.findAll(pageable);
	}


	@Override
	public List<Student> getByKeyword(String keyword) {
		return studentRepository.findByKeyword(keyword);
	}
}
	

