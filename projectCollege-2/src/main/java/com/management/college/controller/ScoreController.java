package com.management.college.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.management.college.entity.Course;
import com.management.college.entity.Score;
import com.management.college.entity.Student;
import com.management.college.repository.CourseRepository;
import com.management.college.repository.StudentRepository;
import com.management.college.services.ScoreService;

@Controller
public class ScoreController {
	
	@Autowired
	private CourseRepository coursenamerep;
	
	@Autowired
	private StudentRepository studentnamerep;
	
	
	

	private ScoreService scoreService;
	public ScoreController(ScoreService scoreService) {
	    super ();
	    this.scoreService = scoreService;
	}
	
	/* handler method
	 * below
	 */
	
	@GetMapping("/scores")
	public String listScores(Model model){
		model.addAttribute("students", scoreService.getAllScores());
		return "scores";
	}
	
	@GetMapping("/scores/new")
	public String createScoreForm(Model model){
		List<Course>listcourse =  coursenamerep.findAll();
		List<Student>liststudent =  studentnamerep.findAll();
		// create score object to hold score form data
		Score score = new Score();
		model.addAttribute("listcourse", listcourse);
		model.addAttribute("liststudent", liststudent);
		model.addAttribute("score", score);
		return "create_score";
		
	}
	@PostMapping("/scores")
	public String saveStudent(@ModelAttribute("score") Score score) {
	    scoreService.saveScore(score);
	    return "redirect:/scores";
}
	
	@GetMapping("/scores/edit/{scoreid}")
	public String editScoreForm(@PathVariable Long scoreid, Model model) {
		model.addAttribute("student", scoreService.getScoreById(scoreid));
		return "edit_score";
	}
	
	@PostMapping("/scores/{scoreid}")
	public String updateScore(@PathVariable Long scoreid,
			@ModelAttribute("score") Score score,
			Model model) {
	
	// get student from database by id
			//Student existingStudent = studentService.getStudentById(id);
		Score existingScore = scoreService.getScoreById(scoreid);
		existingScore.setScoreid(score.getScoreid());
		existingScore.setScoreSTATUS(score.getScoreSTATUS());
		existingScore.setScoreCONTENT(score.getScoreCONTENT());
	
		scoreService.updateScore(existingScore);
		return "redirect:/scores";
		
	}
	@GetMapping("/scores/{scoreid}")
	public String deleteScore(@PathVariable Long scoreid) {
		scoreService.deleteScoreById(scoreid);
		return "redirect:/scores";
	}
}
