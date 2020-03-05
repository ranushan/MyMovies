package com.mymovies.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${resource.api.url}")
	private String BASE_URL;
	
	@Value("${resource.api.url.image}")
	private String BASE_URL_IMAGE;
	
	@Value("${resource.api.key}")
	private String API_KEY;
	
	@Value("${resource.api.language}")
	private String Language;
	
	@RequestMapping(value = "/data/{movie_id}/results_release_dates", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<ResultsRelease_DatesDTO> getAPI_Release_Dates(@PathVariable String movie_id) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		Release_DatesDTO release_Dates = restTemplate.getForObject(BASE_URL+movie_id+"/release_dates"+API_KEY+Language, Release_DatesDTO.class);
		
		//System.out.println(release_Dates.getResults().toString());
		
		return release_Dates.getResults();
		
	}

}
