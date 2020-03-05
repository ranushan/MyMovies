package com.mymovies.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.mymovies.dto.GenreDTO;
import com.mymovies.dto.MovieDTO;

@Controller
public class GenresController {
	
	@Value("${resource.api.url}")
	private String BASE_URL;
	
	@Value("${resource.api.url.image}")
	private String BASE_URL_IMAGE;
	
	@Value("${resource.api.key}")
	private String API_KEY;
	
	@Value("${resource.api.language}")
	private String Language;
	
	
	@RequestMapping(value = "/data/{movie_id}/genres", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<GenreDTO> getMovieGenres(@PathVariable String movie_id) {
		RestTemplate restTemplate = new RestTemplate();
		MovieDTO detail = restTemplate.getForObject(BASE_URL+movie_id+API_KEY+Language, MovieDTO.class);
		return detail.getGenres();

	}
	
}
