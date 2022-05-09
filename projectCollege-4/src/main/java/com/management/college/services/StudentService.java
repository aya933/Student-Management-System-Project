package com.management.college.services;
import java.util.List;

import org.springframework.data.domain.Page;

import com.management.college.entity.Student;


public interface StudentService {
	
	List <Student> getAllStudents();
	
	Student saveStudent (Student student);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
	
	Student getStudentById(Long id);

	Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	
	 public List<Student> getByKeyword(String keyword);
}
