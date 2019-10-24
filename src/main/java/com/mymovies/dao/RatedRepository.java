package com.mymovies.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;

public interface RatedRepository {

	public ArrayList<String> getRatedMoviesListFromUser(long userId);
	public void addRatedToMovie(long userId,String movieId, int rate);
	public void removeRatedToMovie(long userId,String movieId);
	public EntityManager getEm();
	
}
