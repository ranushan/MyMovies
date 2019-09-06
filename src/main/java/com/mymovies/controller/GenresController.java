package com.mymovies.controller;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
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
	
	private String BASE_URL = "https://api.themoviedb.org/3/movie/";
	private String BASE_URL_IMAGE = "https://image.tmbd.org/t/p/w342";
	private String API_KEY = "?api_key=0a2eea61408ba5facdd057f7d11d2f58";
	private String Language = "&language=fr-FR";
	
	
	@RequestMapping(value = "/data/{movie_id}/genres", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<GenreDTO> getMovieGenres(@PathVariable String movie_id) {
		RestTemplate restTemplate = new RestTemplate();
		MovieDTO detail = restTemplate.getForObject(BASE_URL+movie_id+API_KEY+Language, MovieDTO.class);
		return detail.getGenres();

	}
	
}
