package com.ratings.service.business;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratings.service.models.Rating;
import com.ratings.service.models.dto.RatingDto;
import com.ratings.service.models.dto.RatingsEnvelopDto;
import com.ratings.service.repositories.RatingRepository;

@Service
public class RatingBusiness {

	@Autowired
	private RatingRepository ratingRepository;

	@Autowired
	private ModelMapper modelMapper;

	public RatingsEnvelopDto getAllByUserId(Long userId) {
		List<Rating> ratings = ratingRepository.findAllByUserId(userId);
		List<RatingDto> ratingList = ratings.stream().map(this::convertToDto).collect(Collectors.toList());
		return new RatingsEnvelopDto(ratingList);
	}

	public RatingDto rate(RatingDto dto) {
		if (hasUserAndMovieIds(dto)) {
			Rating rating;
			rating = ratingRepository.findOneByUserIdAndMovieId(dto.getUserId(), dto.getMovieId());
			if (rating != null) {
				rating.setRatting(dto.getRatting());
			} else {
				rating = modelMapper.map(dto, Rating.class);
			}

			ratingRepository.save(rating);
		}
		return dto;
	}


	private boolean hasUserAndMovieIds(RatingDto dto) {
		return dto.getMovieId() != null && dto.getUserId() != null;
	}

	private RatingDto convertToDto(Rating rating) {
		return modelMapper.map(rating, RatingDto.class);
	}

}
