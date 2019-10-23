package com.mymovies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mymovies.dto.MovieDTO;
import com.mymovies.entity.User;
import com.mymovies.service.UserService;
import com.mymovies.service.WatchListService;

@Controller
public class WatchlistController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	WatchListService watchlistService;
	
	@RequestMapping(value = "/watchlists", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<MovieDTO> getWatchlists() {
		
		List<MovieDTO> listOfWatchlists = watchlistService.getWatchlists();
		return listOfWatchlists;
		
	}
	
	@RequestMapping(value = "/watchlists/{idMovie}", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public User setWatchlists(@PathVariable("idMovie") int id) {

		User watchlist = watchlistService.setWatchlists(id);
		return watchlist;
		
	}

}
