package com.catalog.service.business;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.catalog.service.constants.IServiceNameConstants;
import com.catalog.service.dtos.movie.MovieBaseDto;
import com.catalog.service.dtos.movie.MovieDto;
import com.catalog.service.dtos.movie.MovieEnvelopDto;
import com.catalog.service.dtos.rating.RatingDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MovieBusiness {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieBusiness.class);

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackMovieInfo", threadPoolKey = "movieInfoPool", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "20"), @HystrixProperty(name = "maxQueueSize", value = "10"), })
	public MovieDto getMovieInfo(RatingDto ratting) {
		MovieDto movieDto = restTemplate.getForObject(IServiceNameConstants.MOVIE_INFO + ratting.getMovieId(),
				MovieDto.class);
		return movieDto;
	}

	@HystrixCommand(fallbackMethod = "getFallbackInsertMovie", threadPoolKey = "movieInsertPool", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "20"), @HystrixProperty(name = "maxQueueSize", value = "10"), })
	public MovieDto insertMovie(MovieBaseDto dto) {
		ResponseEntity<MovieDto> postResult = restTemplate.postForEntity(IServiceNameConstants.MOVIE_CREATE, dto,
				MovieDto.class);
		if (postResult.getStatusCode().is2xxSuccessful()) {
			return postResult.getBody();
		}
		return getFallBackMovieInstance();
	}

	@HystrixCommand(fallbackMethod = "getFallbackGetAll", threadPoolKey = "movieAllPool", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "20"), @HystrixProperty(name = "maxQueueSize", value = "10"), })
	public MovieEnvelopDto getAll() {
		MovieEnvelopDto movieDto = restTemplate.getForObject(IServiceNameConstants.MOVIE_GET_ALL,
				MovieEnvelopDto.class);
		return movieDto;
	}

	@HystrixCommand(fallbackMethod = "getFallbackUpdateMovie", threadPoolKey = "movieUpdatePool", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "20"), @HystrixProperty(name = "maxQueueSize", value = "10"), })
	public MovieDto updateMovie(MovieDto dto) {
		restTemplate.put(IServiceNameConstants.MOVIE_UPDATE, dto);
		return dto;
	}

	public MovieDto getFallbackUpdateMovie(MovieDto dto,Throwable throwable) {
		LOGGER.error("fallback-update movie", throwable);
		return getFallBackMovieInstance();
	}
	
	public MovieEnvelopDto getFallbackGetAll(Throwable throwable) {
		LOGGER.error("fallback-getAll movie", throwable);
		MovieEnvelopDto dto = new MovieEnvelopDto();
		dto.setMovies(Arrays.asList(new MovieDto(StringUtils.EMPTY, StringUtils.EMPTY)));
		return dto;
	}

	public MovieDto getFallbackInsertMovie(MovieBaseDto dto, Throwable throwable) {
		LOGGER.error("fallback-insert movie", throwable);
		return getFallBackMovieInstance();
	}

	public MovieDto getFallbackMovieInfo(RatingDto rating, Throwable throwable) {
		LOGGER.error("fallback - get movie info", throwable);
		return getFallBackMovieInstance();
	}

	public MovieDto getFallBackMovieInstance() {
		return new MovieDto(StringUtils.EMPTY, StringUtils.EMPTY, 0L);
	}

}
