package com.mymovies.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;

public interface FavoriteRepository {
   
	public ArrayList<String> getFavoriteMoviesListFromUser(long userId);
	public void addMovieToFavorite(long userId,String movieId);
	public void removeMovieToFavorite(long userId,String movieId);
	public EntityManager getEm();
	
}
