package com.texoit.teste.silvio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String ano;
	private String title;
	private String studios;
	private String producers;
	private String winner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStudios() {
		return studios;
	}

	public void setStudios(String studios) {
		this.studios = studios;
	}

	public String getProducers() {
		return producers;
	}

	public void setProducers(String producers) {
		this.producers = producers;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", ano=" + ano + ", title=" + title + ", studios=" + studios + ", producers="
				+ producers + ", winner=" + winner + "]";
	}

}
