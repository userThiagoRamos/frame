package com.catalog.service.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog.service.dtos.CatalogEnvelopDto;
import com.catalog.service.dtos.CatalogItemDto;
import com.catalog.service.dtos.movie.MovieDto;
import com.catalog.service.dtos.rating.RatingsEnvelopDto;

@Service
public class CatalogBusiness {

	@Autowired
	private MovieRatingBusiness ratingBusiness;

	@Autowired
	private MovieBusiness movieBusiness;
	

	public CatalogEnvelopDto getCatalogByUserId(Long userId) {
		RatingsEnvelopDto ratingEnvelop = ratingBusiness.getRatingsByUserId(userId);

		List<CatalogItemDto> itens = ratingEnvelop.getRatings().stream().map(ratting -> {
			MovieDto movieDto = movieBusiness.getMovieInfo(ratting);
			return new CatalogItemDto(movieDto.getName(), movieDto.getDescription(), ratting.getRatting());
		}).collect(Collectors.toList());

		return new CatalogEnvelopDto(itens);

	}

}
