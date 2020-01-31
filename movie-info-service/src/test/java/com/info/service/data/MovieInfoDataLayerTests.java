package com.info.service.data;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.info.service.MovieInfoServiceApplication;
import com.info.service.models.Movie;
import com.info.service.repositories.MovieRepository;

@DataJpaTest(showSql = true)
@ContextConfiguration(classes = MovieInfoServiceApplication.class)
public class MovieInfoDataLayerTests {

	private final Long MOVIE_ID = 1234L;

	@Autowired
	private MovieRepository repository;

	@Test
	public void test_findById() {
		Optional<Movie> movieById = repository.findById(MOVIE_ID);
		assertEquals(MOVIE_ID, movieById.get().getMovieId());
	}

	@Test
	public void test_findAll() {
		Iterable<Movie> movies = repository.findAll();
		assertThat(movies).isNotEmpty();
	}
	

}
