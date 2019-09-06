package com.mymovies.service;

import java.util.ArrayList;

public interface FavoriteService {
	
	public void addMovieToFavorite(long userId, String movieId);
	public void removeMovieToFavorite(long userId,String movieId);
	public ArrayList<String> getFavoriteMoviesListFromUser(long userId);
	
}
