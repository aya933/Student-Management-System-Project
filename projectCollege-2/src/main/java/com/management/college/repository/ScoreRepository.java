package com.management.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.college.entity.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {

}
