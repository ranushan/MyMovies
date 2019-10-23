package com.mymovies.service;

import java.util.ArrayList;
import java.util.List;

import com.mymovies.dto.MovieDTO;
import com.mymovies.entity.User;

public interface WatchListService {

	public void addWatchListToMovie(long userId,String movieId);
	public void removeWatchListToMovie(long userId,String movieId);
	public ArrayList<String> getWatchListMoviesListFromUser(long userId);
	public List<MovieDTO> getWatchlists();
	public User setWatchlists(int id);
	
}
