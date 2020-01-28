package com.catalog.service.constants;

public interface IControllerMappingConstants {
	
	String ROOT = "/api";
	
	interface Catalog {
		String BASE = ROOT + "/catalog";
		String GET_BY_USER_ID = "/user/{userId}";
	}
	
	interface Movie {
		String BASE = ROOT + "/movie";
	}
	
	interface Rating {
		String BASE = ROOT + "/rating";
	}
	

}
