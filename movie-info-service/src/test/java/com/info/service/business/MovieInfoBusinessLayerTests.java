package com.info.service.business;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.info.service.MovieInfoServiceApplication;
import com.info.service.models.dto.MovieDto;

@SpringBootTest
@ContextConfiguration(classes = MovieInfoServiceApplication.class)
public class MovieInfoBusinessLayerTests {

	private final Long MOVIE_ID = 1234L;

	@Autowired
	MovieInfoBusiness business;

	@Test
	public void test_getMovieById() {
		MovieDto movieDto = business.getMovieById(MOVIE_ID);
		assertThat(movieDto.getMovieId()).isEqualTo(MOVIE_ID);
	}

	@Test
	public void test_insertMovie() {
		MovieDto movieDto = new MovieDto("Coringa", "DC movie");
		MovieDto createdMovie = business.insertMovie(movieDto);
		assertThat(createdMovie.getMovieId()).isNotNull();
		assertThat(createdMovie.getName()).isEqualTo(movieDto.getName());
		assertThat(createdMovie.getDescription()).isEqualTo(movieDto.getDescription());
	}

	@Test
	public void test_updateMovie() {
		MovieDto movieDto = new MovieDto("Updated Movie", "Updated Description");
		movieDto.setMovieId(MOVIE_ID);
		MovieDto updateMovie = business.updateMovie(movieDto);
		assertThat(updateMovie.getMovieId()).isNotNull();
		assertThat(updateMovie.getName()).isEqualTo(movieDto.getName());
		assertThat(updateMovie.getDescription()).isEqualTo(movieDto.getDescription());

	}
}
