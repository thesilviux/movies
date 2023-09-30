package com.texoit.teste.silvio.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder("studio")
public class MovieAwardedStudio extends MovieAwardedInterval {
	private String studio;

	public MovieAwardedStudio(int interval, int previousWin, int followingWin, String studio) {
		super(interval, previousWin, followingWin);
		this.studio = studio;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	@Override
	public String toString() {
		return "MovieAwardedStudio [getStudio()=" + getStudio() 
		+ ", getInterval()=" + getInterval()
		+ ", getPreviousWin()=" + getPreviousWin() 
		+ ", getFollowingWin()=" + getFollowingWin() + "]";
	}

}
