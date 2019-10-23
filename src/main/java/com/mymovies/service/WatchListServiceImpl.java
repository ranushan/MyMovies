package com.mymovies.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mymovies.controller.MovieController;
import com.mymovies.dao.WatchListRepository;
import com.mymovies.dto.MovieDTO;
import com.mymovies.entity.Movie;
import com.mymovies.entity.User;

@Service
public class WatchListServiceImpl implements WatchListService{

	@Autowired
	WatchListRepository watchListRepository;
	
	@Autowired
	UserService userService;
	
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

	@Override
	public List<MovieDTO> getWatchlists() {
		
		List<MovieDTO> listMovieDTO = new ArrayList<>();
		
		try {
			
			User ConnectedUser = userService.getAllUsers().get(0);
			List<Movie> listMovies = ConnectedUser.getWatchlistMovie();
			
			MovieController mc = new MovieController();
			
			for(Movie m : listMovies) {
				listMovieDTO.add(mc.getAPI_Detail(String.valueOf(m.getId())));
			}
	
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
		
		return listMovieDTO;
		
	}

	@Override
	public User setWatchlists(int id) {
		
		User ConnectedUser = null;
		
		try {
			
			MovieDTO fromApi = new MovieDTO();
			fromApi.setId(id);		
			ObjectMapper om = new ObjectMapper();
			String jsonMovie = om.writeValueAsString(fromApi);
			Movie movie = om.readerFor(Movie.class).readValue(jsonMovie);
			ConnectedUser = userService.getAllUsers().get(0);
			ConnectedUser.addWatchlistMovie(movie);
			userService.updateUser(ConnectedUser);
			
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
		
		return ConnectedUser;
		
	}

}
