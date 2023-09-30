package com.texoit.teste.silvio.model;

public abstract class MovieAwardedInterval {
	private int interval;
	private int previousWin;
	private int followingWin;

	public MovieAwardedInterval(int interval, int previousWin, int followingWin) {
		super();
		this.interval = interval;
		this.previousWin = previousWin;
		this.followingWin = followingWin;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public int getPreviousWin() {
		return previousWin;
	}

	public void setPreviousWin(int previousWin) {
		this.previousWin = previousWin;
	}

	public int getFollowingWin() {
		return followingWin;
	}

	public void setFollowingWin(int followingWin) {
		this.followingWin = followingWin;
	}

}
