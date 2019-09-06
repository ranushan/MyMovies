package com.mymovies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.mymovies.dto.CreditsDTO;

@Controller
public class CreditController {
	
	private String BASE_URL = "https://api.themoviedb.org/3/movie/";
	private String BASE_URL_IMAGE = "https://image.tmbd.org/t/p/w342";
	private String API_KEY = "?api_key=0a2eea61408ba5facdd057f7d11d2f58";
	private String Language = "&language=fr-FR";
	
	// Class Credit
	
	@RequestMapping(value = "/data/{movie_id}/credits", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public CreditsDTO getAPI_Credits(@PathVariable String movie_id) {

		RestTemplate restTemplate = new RestTemplate();

		CreditsDTO credits = restTemplate.getForObject(BASE_URL+movie_id+"/credits"+API_KEY+Language, CreditsDTO.class);

		return credits;

	}

}
