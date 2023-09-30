package com.texoit.teste.silvio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.texoit.teste.silvio.model.MovieAwardedProducer;
import com.texoit.teste.silvio.model.MovieAwardedStudio;
import com.texoit.teste.silvio.model.MovieWinnerProducer;
import com.texoit.teste.silvio.model.MovieWinnerStudio;
import com.texoit.teste.silvio.repository.MovieRepository;

@Service()
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	private String previousStudio;
	private String previousProducer;
	private int previousWin;

	public List<MovieAwardedStudio> findMostAndLeastFrequentWinnerStudios() {
		List<MovieWinnerStudio> list = movieRepository.countWinnerAgregatedByStudios();
		
		List<MovieAwardedStudio> studiosAwarded = new ArrayList<MovieAwardedStudio>();
		previousStudio = "";
		previousWin = 0;
		list.forEach(winner->{
			
			int followingWin = Integer.parseInt(winner.getYear());
			MovieAwardedStudio studio = new MovieAwardedStudio(0, 0, 
				followingWin, 
				winner.getStudios());
			
			if( winner.getStudios().equals(previousStudio)) {
				if(previousWin!=0) {
					studio.setPreviousWin(previousWin);
					studio.setInterval(followingWin-previousWin);
					studiosAwarded.add(studio);
				}
			}else {
				previousStudio = winner.getStudios();
			}
			previousWin = followingWin;
			
		});
		
		
		return studiosAwarded;
	}

	public List<MovieAwardedProducer> findMostAndLeastFrequentWinnerProducers() {
		List<MovieWinnerProducer> list = movieRepository.countWinnerAgregatedByProducers();
		
		List<MovieAwardedProducer> producersAwarded = new ArrayList<MovieAwardedProducer>();
		previousProducer = "";
		previousWin = 0;
		list.forEach(winner->{
			
			int followingWin = Integer.parseInt(winner.getYear());
			MovieAwardedProducer producer = new MovieAwardedProducer(0, 0, 
				followingWin, 
				winner.getProducers());
			
			if( winner.getProducers().equals(previousProducer)) {
				if(previousWin!=0) {
					producer.setPreviousWin(previousWin);
					producer.setInterval(followingWin-previousWin);
					producersAwarded.add(producer);
				}
			}else {
				previousProducer = winner.getProducers();
			}
			previousWin = followingWin;
			
		});
		
		
		return producersAwarded;
	}
}
