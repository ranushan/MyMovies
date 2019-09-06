package com.mymovies.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.mymovies.dto.ImagesDTO;
import com.mymovies.dto.PosterDTO;

@Controller
public class PostersController {
	
	private String BASE_URL = "https://api.themoviedb.org/3/movie/";
	private String BASE_URL_IMAGE = "https://image.tmbd.org/t/p/w342";
	private String API_KEY = "?api_key=0a2eea61408ba5facdd057f7d11d2f58";
	private String Language = "&language=fr-FR";

	@RequestMapping(value = "/data/{movie_id}/posters", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<PosterDTO> getAPI_Images(@PathVariable String movie_id) {

		RestTemplate restTemplate = new RestTemplate();

		ImagesDTO images = restTemplate.getForObject(BASE_URL+movie_id+"/images"+API_KEY+Language, ImagesDTO.class);

		//System.out.println(images.getPosters().toString());
		
		return images.getPosters();

	}

}
