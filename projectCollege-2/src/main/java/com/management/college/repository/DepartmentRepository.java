package com.management.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.college.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
