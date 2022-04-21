package com.management.college.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.management.college.entity.Score;
import com.management.college.repository.ScoreRepository;
import com.management.college.services.ScoreService;


@Service

public class ScoreServiceImplement implements ScoreService {
private ScoreRepository scoreRepository;
	
	
	


	public ScoreServiceImplement(ScoreRepository scoreRepository) {
		super();
		this.scoreRepository = scoreRepository;
	}





	@Override
	public List<Score> getAllScores() {
	 
	    return scoreRepository.findAll();
	}
	
	@Override
	public Score saveScore (Score score) {
	    return scoreRepository.save(score);
	    
	}


	@Override
	public Score getScoreById(Long id) {
		return scoreRepository.findById(id).get();
	}

	@Override
	public Score updateScore(Score score) {
		return scoreRepository.save(score);
	}	
	
	@Override
	public void deleteScoreById(Long id) {
		scoreRepository.deleteById(id);	
	}


}
