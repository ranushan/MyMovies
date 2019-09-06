package com.mymovies.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovies.dao.WatchListRepository;

@Service
public class WatchListServiceImpl implements WatchListService{

	@Autowired
	WatchListRepository watchListRepository;
	
	@Override
	public void addWatchListToMovie(long userId, String movieId) {
		watchListRepository.addWatchListToMovie(userId, movieId);
	}

	@Override
	public void removeWatchListToMovie(long userId, String movieId) {
		watchListRepository.removeWatchListToMovie(userId, movieId);		
	}

	@Override
	public ArrayList<String> getWatchListMoviesListFromUser(long userId) {
		ArrayList<String> listOfWatchListMovieListFromUser = watchListRepository.getWatchListMoviesListFromUser(userId);
		return listOfWatchListMovieListFromUser;
	}

}
