package com.catalog.service.business;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.catalog.service.constants.IServiceNameConstants;
import com.catalog.service.dtos.rating.RatingDto;
import com.catalog.service.dtos.rating.RatingsEnvelopDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MovieRatingBusiness {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackgetRatingsByUserId", threadPoolKey = "listRatingByUserPool", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "20"), @HystrixProperty(name = "maxQueueSize", value = "10"), })
	public RatingsEnvelopDto getRatingsByUserId(Long userId) {
		return restTemplate.getForObject(IServiceNameConstants.RATTINGS + userId, RatingsEnvelopDto.class);
	}

	public RatingsEnvelopDto getFallbackgetRatingsByUserId(Long userId) {
		return new RatingsEnvelopDto(Arrays.asList(new RatingDto()));
	}

	@HystrixCommand(fallbackMethod = "getFallbackgetRate", threadPoolKey = "rateMoviePool", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "20"), @HystrixProperty(name = "maxQueueSize", value = "10"), })
	public RatingDto rate(RatingDto dto) {
		restTemplate.put(IServiceNameConstants.RATE_MOVIE, dto);
		return dto;

	}

	public RatingDto getFallbackgetRate(RatingDto dto,Throwable throwable) {
		throwable.getCause();
		return new RatingDto();
	}

}
