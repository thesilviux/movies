package com.texoit.teste.silvio.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder("producer")
public class MovieAwardedProducer extends MovieAwardedInterval {
	private String producer;

	public MovieAwardedProducer(int interval, int previousWin, int followingWin, String producer) {
		super(interval, previousWin, followingWin);
		this.producer = producer;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer; 
	}

	@Override
	public String toString() {
		return "MovieAwardedProducer [ getProducer()=" + getProducer() 
		+ ", getInterval()=" + getInterval() 
		+ ", getPreviousWin()=" + getPreviousWin() 
		+ ", getFollowingWin()=" + getFollowingWin() + "]";
	}
	
	

}
