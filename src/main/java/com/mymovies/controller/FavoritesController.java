package com.mymovies.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mymovies.dto.MovieDTO;
import com.mymovies.entity.Favorite;
import com.mymovies.entity.Movie;
import com.mymovies.entity.User;
import com.mymovies.service.UserService;


@Controller
public class FavoritesController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/favorites", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<MovieDTO> getFavorites() throws IOException {
		
		/*
		System.out.println("test Jakson ........");
		MovieDTO m = new MovieDTO();
		// m.setAdult(true);
		// m.setOriginal_title("Le scielence des agneaux");

		String jsonMovie = new ObjectMapper().writeValueAsString(m);
		
		ObjectMapper mapper = new ObjectMapper();
		MovieDTO movie = mapper.readValue(jsonMovie, MovieDTO.class);
		MovieDTO movie2 = mapper.readerFor(MovieDTO.class).readValue(jsonMovie);
		
		User ConnectedUser = userService.getAllUsers().get(0);
		return ConnectedUser;
		
		*/

		User ConnectedUser = userService.getAllUsers().get(0);
		List<Movie> listMovies = ConnectedUser.getMovie();
		
		MovieController mc = new MovieController();

		List<MovieDTO> listMovieDTO = new ArrayList<>();
		
		for(Movie m : listMovies) {
			listMovieDTO.add(mc.getAPI_Detail(String.valueOf(m.getId())));
		}
		
		return listMovieDTO;

	}

	
	
	@RequestMapping(value = "/favorites/{idMovie}", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public User setFavorites(@PathVariable("idMovie") int id) throws IOException {

		MovieDTO fromApi = new MovieDTO();
		fromApi.setId(id);		
		ObjectMapper om = new ObjectMapper();
		String jsonMovie = om.writeValueAsString(fromApi);
		Movie movie = om.readerFor(Movie.class).readValue(jsonMovie);
		User ConnectedUser = userService.getAllUsers().get(0);
		ConnectedUser.addMovie(movie);
		userService.updateUser(ConnectedUser);
		
		return ConnectedUser;
		
	}
	
	
	
	
	
	
	
}
