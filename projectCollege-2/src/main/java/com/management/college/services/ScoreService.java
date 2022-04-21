package com.management.college.services;

import java.util.List;

import com.management.college.entity.Score;


public interface ScoreService {
	
	List <Score> getAllScores();
	
	Score saveScore (Score score);
	
	Score getScoreById(Long id);
	
	void deleteScoreById(Long id);

	Score updateScore(Score score);

}
