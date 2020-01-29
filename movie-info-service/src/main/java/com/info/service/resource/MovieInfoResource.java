package com.info.service.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.service.business.MovieInfoBusiness;
import com.info.service.models.dto.MovieBaseDto;
import com.info.service.models.dto.MovieDto;
import com.info.service.models.dto.MovieEnvelopDto;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

	@Autowired
	private MovieInfoBusiness movieBusiness;

	@GetMapping("/{movieId}")
	public MovieDto getMovieInfo(@PathVariable("movieId") Long movieId) {
		return movieBusiness.getMovieById(movieId);
	}

	@PostMapping
	public MovieDto createMovieInfo(@RequestBody MovieBaseDto movie) {
		return movieBusiness.insertMovie(movie);
	}
	
	@PutMapping
	public MovieDto updateMovieInfo(@RequestBody MovieDto movie) {
		return movieBusiness.updateMovie(movie);
	}
	
	@GetMapping
	public MovieEnvelopDto getAll() {
		return movieBusiness.getMovieList();
	}

}
