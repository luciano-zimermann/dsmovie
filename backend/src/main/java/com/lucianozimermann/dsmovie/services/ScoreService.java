package com.lucianozimermann.dsmovie.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucianozimermann.dsmovie.dto.MovieDTO;
import com.lucianozimermann.dsmovie.dto.ScoreDTO;
import com.lucianozimermann.dsmovie.entities.Movie;
import com.lucianozimermann.dsmovie.entities.Score;
import com.lucianozimermann.dsmovie.entities.User;
import com.lucianozimermann.dsmovie.repositories.MovieRepository;
import com.lucianozimermann.dsmovie.repositories.ScoreRepository;
import com.lucianozimermann.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		
		if ( user == null )
		{
			user = new User();
			
			user.setEmail(dto.getEmail());
			
			user = userRepository.saveAndFlush(user);
		}
		
		//Busca o filme do DTO para setar no objeto do Score
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		Set<Score> scores = movie.getScores();
		
		double sum = 0.0;
		
		for (Score s : scores) {
			sum += s.getValue();
		}
		
		double avg = sum / scores.size();
		
		movie.setScore(avg);
		movie.setCount(scores.size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
}
