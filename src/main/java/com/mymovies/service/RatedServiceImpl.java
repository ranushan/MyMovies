package com.mymovies.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mymovies.controller.MovieController;
import com.mymovies.dao.RatedRepository;
import com.mymovies.dto.MovieDTO;
import com.mymovies.entity.Movie;
import com.mymovies.entity.User;

@Service
public class RatedServiceImpl implements RatedService{

	@Autowired
	RatedRepository ratedRepository;
	
	@Autowired
	UserService userService;
	
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

	@Override
	public User setRated(int id) {

		User ConnectedUser = null;
		
		try {
			
			MovieDTO fromApi = new MovieDTO();
			fromApi.setId(id);		
			ObjectMapper om = new ObjectMapper();
			String jsonMovie = om.writeValueAsString(fromApi);
			Movie movie = om.readerFor(Movie.class).readValue(jsonMovie);
			ConnectedUser = userService.getAllUsers().get(0);
			ConnectedUser.addRatedMovie(movie);
			userService.updateUser(ConnectedUser);
			
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}

		return ConnectedUser;
	}

	@Override
	public List<MovieDTO> getRates() {
		
		List<MovieDTO> listMovieDTO = new ArrayList<>();
		
		try {

			User ConnectedUser = userService.getAllUsers().get(0);
			List<Movie> listMovies = ConnectedUser.getRatedMovie();
			
			MovieController mc = new MovieController();

			for(Movie m : listMovies) {
				listMovieDTO.add(mc.getAPI_Detail(String.valueOf(m.getId())));
			}

		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
		
		return listMovieDTO;
		
	}

}
