package com.info.service.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movieId")
	private Long movieId;

	private String name;

	private String description;

	public Movie() {
		super();
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Movie(Long movieId, String name, String description) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.description = description;
	}

	public Movie(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	
}
