package com.mymovies.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.mymovies.dto.Release_DatesDTO;
import com.mymovies.dto.ResultsRelease_DatesDTO;

@Controller
public class ResultsRelease_DatesController {
	
	private String BASE_URL = "https://api.themoviedb.org/3/movie/";
	private String BASE_URL_IMAGE = "https://image.tmbd.org/t/p/w342";
	private String API_KEY = "?api_key=0a2eea61408ba5facdd057f7d11d2f58";
	private String Language = "&language=fr-FR";
	
	@RequestMapping(value = "/data/{movie_id}/results_release_dates", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<ResultsRelease_DatesDTO> getAPI_Release_Dates(@PathVariable String movie_id) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		Release_DatesDTO release_Dates = restTemplate.getForObject(BASE_URL+movie_id+"/release_dates"+API_KEY+Language, Release_DatesDTO.class);
		
		//System.out.println(release_Dates.getResults().toString());
		
		return release_Dates.getResults();
		
	}

}
