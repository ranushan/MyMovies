package com.mymovies.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.mymovies.dto.KeywordsDTO;

@Controller
public class KeywordsController {
	
	@Value("${resource.api.url}")
	private String BASE_URL;
	
	@Value("${resource.api.url.image}")
	private String BASE_URL_IMAGE;
	
	@Value("${resource.api.key}")
	private String API_KEY;
	
	@Value("${resource.api.language}")
	private String Language;
	
	@RequestMapping(value = "/data/{movie_id}/keywords", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public KeywordsDTO getAPI_Keywords(@PathVariable String movie_id) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		KeywordsDTO keywords = restTemplate.getForObject(BASE_URL+movie_id+"/keywords"+API_KEY+Language, KeywordsDTO.class);
		
		// System.out.println(keywords.toString());
		
		return keywords;
		
	}
	
}
