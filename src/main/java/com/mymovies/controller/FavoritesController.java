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
import com.mymovies.service.FavoriteService;
import com.mymovies.service.UserService;


@Controller
public class FavoritesController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	FavoriteService favoriteService;
	
	@RequestMapping(value = "/favorites", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<MovieDTO> getFavorites() {
		
		List<MovieDTO> listOfFavorites = favoriteService.getFavorites();
		return listOfFavorites;

	}

	
	@RequestMapping(value = "/favorites/{idMovie}", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public User setFavorites(@PathVariable("idMovie") int id) {

		User favorite = favoriteService.setFavorites(id);
		return favorite;
		
	}

	
}
