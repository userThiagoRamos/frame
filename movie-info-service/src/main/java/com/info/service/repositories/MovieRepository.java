package com.info.service.repositories;

import org.springframework.data.repository.CrudRepository;

import com.info.service.models.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long>{
	
	

}
