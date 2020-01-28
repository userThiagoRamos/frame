package com.catalog.service.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.service.business.MovieRatingBusiness;
import com.catalog.service.constants.IControllerMappingConstants;
import com.catalog.service.dtos.rating.RatingDto;

@RestController
@RequestMapping(name = IControllerMappingConstants.Rating.BASE,produces = MediaType.APPLICATION_JSON_VALUE)
public class RatingResource {
	
	@Autowired
	private MovieRatingBusiness ratingBusiness;
	
	@PutMapping("/rate")
	public RatingDto movie(@RequestBody RatingDto dto) {
		return ratingBusiness.rate(dto);
	}

}
