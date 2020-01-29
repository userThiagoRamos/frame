package com.ratings.service.models.dto;

import java.io.Serializable;

public class RatingDto implements Serializable{
	
	private static final long serialVersionUID = 484210758544106909L;
		
	private Long movieId;
	private int ratting;
	private Long userId;
	
	
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public int getRatting() {
		return ratting;
	}
	public void setRatting(int ratting) {
		this.ratting = ratting;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public RatingDto() {
		super();
	}

	

}
