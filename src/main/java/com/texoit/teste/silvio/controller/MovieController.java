package com.texoit.teste.silvio.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texoit.teste.silvio.model.MovieAwardedProducer;
import com.texoit.teste.silvio.model.MovieAwardedResponse;
import com.texoit.teste.silvio.model.MovieAwardedStudio;
import com.texoit.teste.silvio.model.MovieWinnerProducer;
import com.texoit.teste.silvio.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/producers")
	public MovieAwardedResponse producers() {

		List<MovieAwardedProducer> producers = movieService
				.findMostAndLeastFrequentWinnerProducers();

		Map<Integer, List<MovieAwardedProducer>> resultsByInterval = producers
		    .stream()
		    .collect(
		        Collectors.groupingBy(MovieAwardedProducer::getInterval,
		        		Collectors.toList())
		    );
		
		Set<Integer> keySet = resultsByInterval.keySet();
		System.out.println(keySet);
		

		Optional<Integer> min = producers.stream()
			.map(MovieAwardedProducer::getInterval)
			.collect(Collectors.minBy(Comparator.naturalOrder()));
		System.out.println("Min: " + min);

		Optional<Integer> max = producers.stream()
			.map(MovieAwardedProducer::getInterval)
			.collect(Collectors.maxBy(Comparator.naturalOrder()));
		System.out.println("Max: " + max);
		
		MovieAwardedResponse movieAwardedResponse = new MovieAwardedResponse();
		if(min.isPresent()) {
			List<MovieAwardedProducer> minSet = resultsByInterval.get(min.get());
			movieAwardedResponse.getMin().addAll(minSet);
		}
		if(max.isPresent()) {
			List<MovieAwardedProducer> maxSet = resultsByInterval.get(max.get());
			movieAwardedResponse.getMax().addAll(maxSet);
		}

		return movieAwardedResponse;

	}

	@GetMapping("/studios")
	public MovieAwardedResponse studios() {

		List<MovieAwardedStudio> studios = movieService
				.findMostAndLeastFrequentWinnerStudios();

		Map<Integer, List<MovieAwardedStudio>> resultsByInterval = studios
		    .stream()
		    .collect(
		        Collectors.groupingBy(MovieAwardedStudio::getInterval,
		        		Collectors.toList())
		    );
		
		Set<Integer> keySet = resultsByInterval.keySet();
		System.out.println(keySet);
		

		Optional<Integer> min = studios.stream()
			.map(MovieAwardedStudio::getInterval)
			.collect(Collectors.minBy(Comparator.naturalOrder()));
		System.out.println("Min: " + min);

		Optional<Integer> max = studios.stream()
			.map(MovieAwardedStudio::getInterval)
			.collect(Collectors.maxBy(Comparator.naturalOrder()));
		System.out.println("Max: " + max);
		
		MovieAwardedResponse movieAwardedResponse = new MovieAwardedResponse();
		if(min.isPresent()) {
			List<MovieAwardedStudio> minSet = resultsByInterval.get(min.get());
			movieAwardedResponse.getMin().addAll(minSet);
		}
		if(max.isPresent()) {
			List<MovieAwardedStudio> maxSet = resultsByInterval.get(max.get());
			movieAwardedResponse.getMax().addAll(maxSet);
		}

		return movieAwardedResponse;
	}
}
