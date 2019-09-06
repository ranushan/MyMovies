package com.mymovies.service;

import java.util.ArrayList;

public interface RatedService {
	
	public void addRatedToMovie(long userId,String movieId);
	public void removeRatedToMovie(long userId,String movieId);
	public ArrayList<String> getRatedMoviesListFromUser(long userId);

}

