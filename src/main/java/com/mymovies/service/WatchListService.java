package com.mymovies.service;

import java.util.ArrayList;

public interface WatchListService {

	public void addWatchListToMovie(long userId,String movieId);
	public void removeWatchListToMovie(long userId,String movieId);
	public ArrayList<String> getWatchListMoviesListFromUser(long userId);

}
