package com.catalog.service.dtos.rating;

import java.io.Serializable;
import java.util.List;

public class RatingsEnvelopDto implements Serializable {

	private static final long serialVersionUID = 7712274511860420528L;
	
	private List<RatingDto> ratings;

	public RatingsEnvelopDto() {
		super();
	}

	public RatingsEnvelopDto(List<RatingDto> movieRatings) {
		this.ratings = movieRatings;
	}

	public List<RatingDto> getRatings() {
		return ratings;
	}

	public void setRatings(List<RatingDto> ratings) {
		this.ratings = ratings;
	}

}
