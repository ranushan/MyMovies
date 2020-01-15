package com.mymovies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class DiscoverController {

	String BASE_URL = "https://api.themoviedb.org/3/discover/movie";
	String BASE_URL_IMAGE = "https://image.tmbd.org/t/p/w342";
	String API_KEY = "?api_key=0a2eea61408ba5facdd057f7d11d2f58";
	String Language = "&language=fr-FR";

	//https://api.themoviedb.org/3/discover/movie?api_key=0a2eea61408ba5facdd057f7d11d2f58&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&year=2019
	
	// Class Test Discover 20 films generer
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/discover", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getApi_Discover() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String discover = restTemplate.getForObject(BASE_URL+API_KEY+Language+"&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&year=2019", String.class);
		
		//System.out.println(discover);
		
		return discover;
	}
	
}
