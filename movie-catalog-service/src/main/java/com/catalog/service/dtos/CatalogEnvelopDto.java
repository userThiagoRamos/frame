package com.catalog.service.dtos;

import java.io.Serializable;
import java.util.List;

public class CatalogEnvelopDto implements Serializable {

	private static final long serialVersionUID = -8365841522862574316L;
	
	private List<CatalogItemDto> catalog;

	public List<CatalogItemDto> getCatalog() {
		return catalog;
	}

	public void setCatalog(List<CatalogItemDto> catalog) {
		this.catalog = catalog;
	}

	public CatalogEnvelopDto(List<CatalogItemDto> catalog) {
		super();
		this.catalog = catalog;
	}

	public CatalogEnvelopDto() {
		super();
	}

}
