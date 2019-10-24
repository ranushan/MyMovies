package com.mymovies.service;

import java.util.ArrayList;
import java.util.List;

import com.mymovies.dto.MovieDTO;
import com.mymovies.entity.User;

public interface RatedService {
	
	public void addRatedToMovie(long userId,String movieId, int rate);
	public void removeRatedToMovie(long userId,String movieId);
	public ArrayList<String> getRatedMoviesListFromUser(long userId);
	public User setRated(int id);
	public List<MovieDTO> getRates();
	
}

