package com.rattings.service.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.ratings.service.RatingsDataServiceApplication;
import com.ratings.service.business.RatingBusiness;
import com.ratings.service.models.Rating;
import com.ratings.service.models.dto.RatingDto;
import com.ratings.service.models.dto.RatingsEnvelopDto;
import com.ratings.service.repositories.RatingRepository;

@SpringBootTest
@ContextConfiguration(classes = RatingsDataServiceApplication.class)
public class RatingBusinessLayerTests {

	@Autowired
	RatingBusiness ratingBusiness;
	
	@Autowired
	RatingRepository repository;

	RatingDto ratingDto;
	RatingsEnvelopDto envelop;

	@BeforeEach
	public void before() {
		ratingDto =  new RatingDto();
		ratingDto.setMovieId(1234L);
		ratingDto.setRatting(1);
		ratingDto.setUserId(1L);
		envelop = new RatingsEnvelopDto(Collections.singletonList(ratingDto));
	}

	@Test
	public void test_getAllByUserId() {
		RatingsEnvelopDto create = ratingBusiness.getAllByUserId(1L);
		assertThat(create.getRatings()).isNotEmpty();
	}
	
	@Test
	public void test_rateMovie() {
		ratingDto.setRatting(3);
		RatingDto rated = ratingBusiness.rate(ratingDto);
		Rating movieRate = repository.findOneByUserIdAndMovieId(1L, 1234L);
		assertEquals(movieRate.getRatting(), rated.getRatting());
	}

}
