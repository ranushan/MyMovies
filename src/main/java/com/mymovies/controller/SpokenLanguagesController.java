package com.mymovies.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

public class SpokenLanguagesController {
	
	private String BASE_URL = "https://api.themoviedb.org/3/movie/";
	private String BASE_URL_IMAGE = "https://image.tmbd.org/t/p/w342";
	private String API_KEY = "?api_key=0a2eea61408ba5facdd057f7d11d2f58";
	private String Language = "&language=fr-FR";
	
	// Class Movies
	
	@RequestMapping(value = "/data/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getAPI_Detail(@PathVariable String movie_id) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String detail = restTemplate.getForObject(BASE_URL+movie_id+API_KEY+Language, String.class);
							
		return detail;
		
	}

}
