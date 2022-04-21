package com.management.college.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.college.entity.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
 
}