package com.mymovies.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.mymovies.dto.GenreDTO;
import com.mymovies.dto.ListGenresAvailableDTO;


@Controller
public class ListGenresAvailableController {
	
	@Value("${resource.api.url}")
	private String BASE_URL;
	
	@Value("${resource.api.url.image}")
	private String BASE_URL_IMAGE;
	
	@Value("${resource.api.key}")
	private String API_KEY;
	
	@Value("${resource.api.language}")
	private String Language;
	
	@RequestMapping(value = "/data/listgenres", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<GenreDTO> getAPI_ListGenres() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		ListGenresAvailableDTO listGenresAvailables = restTemplate.getForObject(BASE_URL+API_KEY+Language, ListGenresAvailableDTO.class);
		
		/*JSONObject jsonObjectListGenres = new JSONObject(listGenresAvailables);
		
		JSONArray jsonArrayGenre = jsonObjectListGenres.getJSONArray("genres");
		
		//for(i)
		
		JSONObject jsonObject = jsonArrayGenre.getJSONObject(0);
		
		System.out.println(jsonObject.get("id"));
		
		try {
			ListGenresAvailableDTO genre = new ObjectMapper().readValue(jsonObject.toString(), ListGenresAvailableDTO.class);
			System.out.println(genre.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		*/
		
		return listGenresAvailables.getGenres();
		
	}
	
}
