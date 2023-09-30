package com.texoit.teste.silvio.model;

import java.util.ArrayList;
import java.util.List;

public class MovieAwardedResponse {

	List<MovieAwardedInterval> min = new ArrayList<MovieAwardedInterval>();
	List<MovieAwardedInterval> max = new ArrayList<MovieAwardedInterval>();
	
	public List<MovieAwardedInterval> getMin() {
		return min;
	}
	
	public List<MovieAwardedInterval> getMax() {
		return max;
	}

}
