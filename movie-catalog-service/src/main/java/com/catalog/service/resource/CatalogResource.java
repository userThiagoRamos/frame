package com.catalog.service.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.service.business.CatalogBusiness;
import com.catalog.service.constants.IControllerMappingConstants;
import com.catalog.service.dtos.CatalogEnvelopDto;

@RestController
@RequestMapping(name=IControllerMappingConstants.Catalog.BASE,produces = MediaType.APPLICATION_JSON_VALUE)
public class CatalogResource {

	@Autowired
	private CatalogBusiness catalogBusiness;

	@GetMapping("/user/{userId}")
	public CatalogEnvelopDto byUserId(@PathVariable("userId") Long userId) {
		return catalogBusiness.getCatalogByUserId(userId);
	}
	


}
