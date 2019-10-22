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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mymovies.dto.MovieDTO;
import com.mymovies.entity.Movie;
import com.mymovies.entity.User;
import com.mymovies.service.UserService;

@Controller
public class WatchlistController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/watchlists", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<MovieDTO> getWatchlists() throws IOException {
		
		User ConnectedUser = userService.getAllUsers().get(0);
		List<Movie> listMovies = ConnectedUser.getWatchlistMovie();
		
		MovieController mc = new MovieController();

		List<MovieDTO> listMovieDTO = new ArrayList<>();
		
		for(Movie m : listMovies) {
			listMovieDTO.add(mc.getAPI_Detail(String.valueOf(m.getId())));
		}
		
		return listMovieDTO;
		
	}
	
	@RequestMapping(value = "/watchlists/{idMovie}", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public User setWatchlists(@PathVariable("idMovie") int id) throws IOException {

		MovieDTO fromApi = new MovieDTO();
		fromApi.setId(id);		
		ObjectMapper om = new ObjectMapper();
		String jsonMovie = om.writeValueAsString(fromApi);
		Movie movie = om.readerFor(Movie.class).readValue(jsonMovie);
		User ConnectedUser = userService.getAllUsers().get(0);
		ConnectedUser.addWatchlistMovie(movie);
		userService.updateUser(ConnectedUser);
		
		return ConnectedUser;
		
	}

}
