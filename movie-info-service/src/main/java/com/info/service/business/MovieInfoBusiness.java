package com.info.service.business;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.service.models.Movie;
import com.info.service.models.dto.MovieBaseDto;
import com.info.service.models.dto.MovieDto;
import com.info.service.models.dto.MovieEnvelopDto;
import com.info.service.repositories.MovieRepository;

@Service
public class MovieInfoBusiness {
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ModelMapper modelMapper;

	public MovieDto getMovieById(Long movieId) {
		Movie movie = movieRepository.findById(movieId).orElse(new Movie());
		return modelMapper.map(movie, MovieDto.class);
	}

	public MovieDto insertMovie(MovieBaseDto movieDto) {
		Movie movie = modelMapper.map(movieDto, Movie.class);
		Movie savedMovie = movieRepository.save(movie);
		return modelMapper.map(savedMovie, MovieDto.class);
	}

	public MovieDto updateMovie(MovieDto movieDto) {
		if (movieRepository.existsById(movieDto.getMovieId())) {
			Movie movie = modelMapper.map(movieDto, Movie.class);
			movieRepository.save(movie);
		}
		return movieDto;
	}
	
	public MovieEnvelopDto getMovieList() {
		List<Movie> list = (List<Movie>) movieRepository.findAll();
		MovieEnvelopDto dto = new MovieEnvelopDto();
		List<MovieDto> movies = list.stream().map(this::convertToDto).collect(Collectors.toList());
		dto.setMovies(movies);
		return dto;
	}
	
	private MovieDto convertToDto(Movie movie) {
		return modelMapper.map(movie,MovieDto.class);
	}

}
