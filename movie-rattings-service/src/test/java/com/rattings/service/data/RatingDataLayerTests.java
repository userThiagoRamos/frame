package com.rattings.service.data;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.hibernate.annotations.SelectBeforeUpdate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

import com.ratings.service.RatingsDataServiceApplication;
import com.ratings.service.models.Rating;
import com.ratings.service.repositories.RatingRepository;

@DataJpaTest(showSql = true)
@ContextConfiguration(classes = RatingsDataServiceApplication.class)
class RatingDataLayerTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private RatingRepository repository;

	private Rating defaultRating;

	@BeforeEach
	public void setup() {
		assertThat(repository).isNotNull();
		defaultRating = new Rating(1234L, 5, 1L);
	}

	@Test
	void shouldPersistRating() {
		Rating savedRating = repository.save(defaultRating);
		assertThat(savedRating.getRatingId()).isNotNull();
		assertThat(entityManager.find(Rating.class, savedRating.getRatingId())).isNotNull();
	}

	@Test
	void shouldFindByMovieId() {
		List<Rating> ratings = repository.findAllByMovieId(1234L);
		assertThat(ratings).isNotEmpty();
	}

	@Test
	void shouldFindByUserIdAndMovieId() {
		Rating rating = repository.findOneByUserIdAndMovieId(1L, 1234L);
		assertThat(rating.getMovieId()).isNotNull();
		assertThat(rating.getUserId()).isNotNull();
		assertEquals(1L, rating.getUserId());
		assertEquals(1234L, rating.getMovieId());
	}

	@Test
	void shouldFindByUserId() {
		List<Rating> ratings = repository.findAllByUserId(1L);
		assertThat(ratings).isNotEmpty();
		assertThat(ratings.size()).isEqualTo(2);

	}

}
