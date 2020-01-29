package com.info.service.models.dto;

import java.io.Serializable;

public class MovieBaseDto implements Serializable {

	private static final long serialVersionUID = -470798130930658884L;

	private String name;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MovieBaseDto(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public MovieBaseDto() {
		super();
	}

}
