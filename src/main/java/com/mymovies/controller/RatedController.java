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
import com.mymovies.service.RatedService;
import com.mymovies.service.UserService;

@Controller
public class RatedController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RatedService ratedService;
	
	@RequestMapping(value = "/rates", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<MovieDTO> getRates() {
		
		List<MovieDTO> listOfRates = ratedService.getRates();
		return listOfRates;
		
	}
	
	@RequestMapping(value = "/rates/{idMovie}", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public User setWatchlists(@PathVariable("idMovie") int id) {

		User rate = ratedService.setRated(id);
		return rate;
		
	}


}
