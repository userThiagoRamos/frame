package com.catalog.service.dtos.movie;

public class MovieDto extends MovieBaseDto {

	private static final long serialVersionUID = -3571555477768577119L;

	private Long movieId;

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public MovieDto() {
		super();
	}

	public MovieDto(String name, String description) {
		super(name, description);
	}

	public MovieDto(String name, String description, Long movieId) {
		super(name, description);
		this.movieId = movieId;
	}

}
