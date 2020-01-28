package com.catalog.service.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.service.business.MovieBusiness;
import com.catalog.service.constants.IControllerMappingConstants;
import com.catalog.service.dtos.movie.MovieBaseDto;
import com.catalog.service.dtos.movie.MovieDto;
import com.catalog.service.dtos.movie.MovieEnvelopDto;

@RestController
@RequestMapping(name = IControllerMappingConstants.Movie.BASE,produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieResource {
	
	@Autowired
	private MovieBusiness movieBusiness;

	@PostMapping
	public MovieDto createMovie(@RequestBody() MovieBaseDto dto) {
		return movieBusiness.insertMovie(dto);
	}
	
	@PutMapping
	public MovieDto updateMovie(@RequestBody MovieDto dto) {
		return movieBusiness.updateMovie(dto);
	}
	
	@GetMapping
	public MovieEnvelopDto all() {
		return movieBusiness.getAll();
	}
}
