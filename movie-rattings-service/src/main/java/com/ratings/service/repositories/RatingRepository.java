package com.ratings.service.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ratings.service.models.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long>{
	
	List<Rating>  findAllByMovieId(Long movieId);
	
	Rating findOneByUserIdAndMovieId(Long userId,Long movieId);

	List<Rating> findAllByUserId(Long userId);

}
