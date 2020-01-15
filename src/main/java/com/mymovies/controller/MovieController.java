package com.mymovies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.mymovies.dto.MovieDTO;


@Controller
public class MovieController {

	private String BASE_URL = "https://api.themoviedb.org/3/movie/";
	// private String BASE_URL_IMAGE = "https://image.tmbd.org/t/p/w342";
	private String API_KEY = "?api_key=0a2eea61408ba5facdd057f7d11d2f58";
	private String Language = "&language=fr-FR";
	
	// Class Movies
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/movie/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public MovieDTO getAPI_Detail(@PathVariable String movie_id) {
		
		RestTemplate restTemplate = new RestTemplate();
		MovieDTO detail = restTemplate.getForObject(BASE_URL+movie_id+API_KEY+Language, MovieDTO.class);
		detail.setPoster_path(detail.getPoster_path());
		return detail;
		
	}
	
	@RequestMapping(value = "/data/{movie_id}/All", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getAPI_DetailAll(@PathVariable String movie_id) {
		
		RestTemplate restTemplate = new RestTemplate();
		return  restTemplate.getForObject(BASE_URL+movie_id+API_KEY+Language, String.class);
		
	}
}

/*

/// Exemple
	
	{
   "pageInfo": {
         "pageName": "Homepage",
         "logo": "https://www.example.com/logo.jpg"
    },
    "posts": [
         {
              "post_id": "0123456789",
              "actor_id": "1001",
              "author_name": "Jane Doe",
              "post_title": "How to parse JSON in Java",
              "comments": [],
              "time_of_post": "1234567890"
         }
    ]
}
	 
	String json = "lien
	JSONObject obj = new JSONObject(json);

	String pageName = obj.getJSONObject("pageInfo").getString("pageName");
	
	System.out.println(pageName);
	
	JSONArray arr = obj.getJSONArray("posts");
	for (int i = 0; i < arr.length(); i++) {
	    String post_id = arr.getJSONObject(i).getString("post_id");
	    System.out.println(post_id);
	}

///

 */
