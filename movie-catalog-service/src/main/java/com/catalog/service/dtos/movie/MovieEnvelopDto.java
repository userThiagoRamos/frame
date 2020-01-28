package com.catalog.service.dtos.movie;

import java.io.Serializable;
import java.util.List;

public class MovieEnvelopDto implements Serializable {

	private static final long serialVersionUID = 200326596334610831L;

	private List<MovieDto> movies;

	public List<MovieDto> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieDto> movies) {
		this.movies = movies;
	}

	public MovieEnvelopDto() {
		super();
	}

}
