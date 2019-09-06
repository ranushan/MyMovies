package com.mymovies.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.mymovies.dto.MovieDTO;
import com.mymovies.dto.Production_CompaniesDTO;

@Controller
public class Production_CompaniesController {

	private String BASE_URL = "https://api.themoviedb.org/3/movie/";
	private String BASE_URL_IMAGE = "https://image.tmbd.org/t/p/w342";
	private String API_KEY = "?api_key=0a2eea61408ba5facdd057f7d11d2f58";
	private String Language = "&language=fr-FR";

	// Class Production Companies

	@RequestMapping(value = "/data/{movie_id}/productioncompanies", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Production_CompaniesDTO> getAPI_Production_Companies(@PathVariable String movie_id) {
		RestTemplate restTemplate = new RestTemplate();
		MovieDTO detail = restTemplate.getForObject(BASE_URL+movie_id+API_KEY+Language, MovieDTO.class);
		return detail.getProduction_companies();

	}


}
