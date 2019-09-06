package com.mymovies.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovies.dao.FavoriteRepository;

@Service
public class FavoriteServiceImpl implements FavoriteService{

	@Autowired
	FavoriteRepository favoriteRepository;

	@Override
	public void addMovieToFavorite(long userId, String movieId) {
		favoriteRepository.addMovieToFavorite(userId, movieId);
	}

	@Override
	public void removeMovieToFavorite(long userId, String movieId) {
		favoriteRepository.removeMovieToFavorite(userId, movieId);
	}

	@Override
	public ArrayList<String> getFavoriteMoviesListFromUser(long userId) {
		ArrayList<String> listFavoriteMovieListFromUser = favoriteRepository.getFavoriteMoviesListFromUser(userId);
		return listFavoriteMovieListFromUser;
	}

}
