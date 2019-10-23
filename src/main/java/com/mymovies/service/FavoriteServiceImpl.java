package com.mymovies.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mymovies.controller.MovieController;
import com.mymovies.dao.FavoriteRepository;
import com.mymovies.dto.MovieDTO;
import com.mymovies.entity.Movie;
import com.mymovies.entity.User;

@Service
public class FavoriteServiceImpl implements FavoriteService{

	@Autowired
	FavoriteRepository favoriteRepository;
	
	@Autowired
	UserService userService;

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

	@Override
	public User setFavorites(int id) {

		User ConnectedUser = null;
		
		try {
			
			MovieDTO fromApi = new MovieDTO();
			fromApi.setId(id);		
			ObjectMapper om = new ObjectMapper();
			String jsonMovie = om.writeValueAsString(fromApi);
			Movie movie = om.readerFor(Movie.class).readValue(jsonMovie);
			ConnectedUser = userService.getAllUsers().get(0);
			ConnectedUser.addFavoriteMovie(movie);
			userService.updateUser(ConnectedUser);
			
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}

		return ConnectedUser;
		
	}

	@Override
	public List<MovieDTO> getFavorites() {
		
		List<MovieDTO> listMovieDTO = new ArrayList<>();
		
		try {
			
			/*
			System.out.println("test Jakson ........");
			MovieDTO m = new MovieDTO();
			// m.setAdult(true);
			// m.setOriginal_title("Le scielence des agneaux");

			String jsonMovie = new ObjectMapper().writeValueAsString(m);
			
			ObjectMapper mapper = new ObjectMapper();
			MovieDTO movie = mapper.readValue(jsonMovie, MovieDTO.class);
			MovieDTO movie2 = mapper.readerFor(MovieDTO.class).readValue(jsonMovie);
			
			User ConnectedUser = userService.getAllUsers().get(0);
			return ConnectedUser;
			
			*/

			User ConnectedUser = userService.getAllUsers().get(0);
			List<Movie> listMovies = ConnectedUser.getFavoriteMovie();
			
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
