package com.ratings.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RatingsDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingsDataServiceApplication.class, args);
	}

	@Bean
	ModelMapper getModelMapper() {
		ModelMapper mapper  = new ModelMapper();
		 mapper.getConfiguration().setAmbiguityIgnored(true).
		setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper;
	}

}
