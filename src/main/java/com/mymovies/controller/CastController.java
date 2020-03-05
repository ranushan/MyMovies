package com.mymovies.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.mymovies.dto.CastDTO;
import com.mymovies.dto.CreditsDTO;

@Controller
public class CastController {

	@Value("${resource.api.url}")
	private String BASE_URL;
	
	@Value("${resource.api.url.image}")
	private String BASE_URL_IMAGE;
	
	@Value("${resource.api.key}")
	private String API_KEY;
	
	@Value("${resource.api.language}")
	private String Language;

	// Class Cast
	
	@RequestMapping(value = "/data/{movie_id}/cast", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<CastDTO> getAPI_Cast(@PathVariable String movie_id) {

		RestTemplate restTemplate = new RestTemplate();

		CreditsDTO credits = restTemplate.getForObject(BASE_URL+movie_id+"/credits"+API_KEY+Language, CreditsDTO.class);

		// System.out.println(credits.getCast().toString());
		
		return credits.getCast();

	}

}
