package com.mymovies.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovies.dao.RatedRepository;

@Service
public class RatedServiceImpl implements RatedService{

	@Autowired
	RatedRepository ratedRepository;
	
	@Override
	public void addRatedToMovie(long userId, String movieId) {
		ratedRepository.addRatedToMovie(userId, movieId);	
	}

	@Override
	public void removeRatedToMovie(long userId, String movieId) {
		ratedRepository.removeRatedToMovie(userId, movieId);	
	}

	@Override
	public ArrayList<String> getRatedMoviesListFromUser(long userId) {
		ArrayList<String> listRatedMovieListFromUser = ratedRepository.getRatedMoviesListFromUser(userId);
		return listRatedMovieListFromUser;
	}

}
