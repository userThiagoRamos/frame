package com.ratings.service.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratings.service.business.RatingBusiness;
import com.ratings.service.models.dto.RatingDto;
import com.ratings.service.models.dto.RatingsEnvelopDto;

@RestController
@RequestMapping("/ratings")
public class RatingDataResource {
	
	@Autowired
	private RatingBusiness ratingBusiness;
	
	@GetMapping("/{userId}")
	public RatingsEnvelopDto getRatting(@PathVariable("userId")Long userId) {
		return ratingBusiness.getAllByUserId(userId);
	}
	
	@PutMapping("/rate")
	public RatingDto rateMovie(@RequestBody RatingDto dto) {
		return ratingBusiness.rate(dto);
	}


}
