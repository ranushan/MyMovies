package com.mymovies.service;

import java.util.ArrayList;
import java.util.List;

import com.mymovies.dto.MovieDTO;
import com.mymovies.entity.User;

public interface FavoriteService {
	
	public void addMovieToFavorite(long userId, String movieId);
	public void removeMovieToFavorite(long userId,String movieId);
	public ArrayList<String> getFavoriteMoviesListFromUser(long userId);
	public User setFavorite(int id);
	public List<MovieDTO> getFavorites();
	
}
