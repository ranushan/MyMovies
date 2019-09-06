package com.mymovies.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;

public interface WatchListRepository {
	
	public ArrayList<String> getWatchListMoviesListFromUser(long userId);
	public void addWatchListToMovie(long userId,String movieId);
	public void removeWatchListToMovie(long userId,String movieId);
	public EntityManager getEm();

}
