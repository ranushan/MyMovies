package com.mymovies;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mymovies.entity.Favorite;
import com.mymovies.entity.Movie;
import com.mymovies.entity.User;
import com.mymovies.entity.WatchList;
import com.mymovies.service.FavoriteService;
import com.mymovies.service.UserService;
import com.mymovies.service.WatchListService;

@SpringBootApplication
public class MyMoviesApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	@Autowired
	FavoriteService favoriteService;
	
	@Autowired
	WatchListService watchlistService;


	public static void main(String[] args) {
		SpringApplication.run(MyMoviesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("START");

		// API number : 0a2eea61408ba5facdd057f7d11d2f58

		// ------------------------ Test de la Classe USER

		/*
		 * 
		 * // Creer l'utilisateur 1
		 * 
		 * User user = new User();
		 * 
		 * user.setId(1); user.setRole("Administrateur");
		 * user.setUsername("Utilisateur"); user.setFirstname("Ranushan");
		 * user.setName("RACHU"); user.setPassword("motdepasse");
		 * user.setEmail("ranusha.n@hotmail.fr"); user.setImage("maphoto.jpeg");
		 * user.setAge(18);
		 * 
		 * userService.encryptPassword(user); // Encryptage du password
		 * 
		 * userService.addUser(user); // Ajout dans la base de donnee l'utilisateur
		 * 
		 * //userService.validatePassword(user); // Match password base de donnee et
		 * formulaire
		 * 
		 * // Creer l'utilisateur 2
		 * 
		 * User user1 = new User();
		 * 
		 * user1.setId(2); user1.setRole("Invite"); user1.setUsername("Utilisateur");
		 * user1.setFirstname("Ranushan"); user1.setName("RACHU");
		 * user1.setPassword("motdepasse"); user1.setEmail("ranusha.n@hotmail.fr");
		 * user1.setImage("maphoto.jpeg"); user1.setAge(16);
		 * 
		 * userService.encryptPassword(user1); // Encryptage du password
		 * 
		 * userService.addUser(user1); // Ajout dans la base de donnee l'utilisateur
		 * 
		 * //userService.validatePassword(user1); // Match password base de donnee et
		 * formulaire
		 * 
		 * // Parcourir la liste des utilisateurs présentent dans la base de donnee
		 * 
		 * List<User> listUser = userService.getAllUsers();
		 * 
		 * for(User u : listUser) {
		 * 
		 * System.out.println("User : " + u);
		 * 
		 * }
		 * 
		 */

		// ------------------------ Test de la Classe Favorite

		// Creer l'utilisateur 1

		User user = new User();

		user.setId(1);
		user.setRole("Administrateur");
		user.setUsername("Utilisateur");
		user.setFirstname("Ranushan");
		user.setName("RACHU");
		user.setPassword("motdepasse");
		user.setEmail("ranusha.n@hotmail.fr");
		user.setImage("maphoto.jpeg");
		user.setAge(18);
		
		
		userService.addUser(user); // Ajout dans la base de donnee l'utilisateur

		userService.validatePassword(user); // Match password base de donnee et formulaire

		/*
		 
		// Movie
		 
		Movie movie = new Movie();
		movie.setId(11);
		
		// Favorite
		
		Favorite favorite = new Favorite();
		favorite.setId_movie(String.valueOf(movie.getId()));
		favorite.setId_user(user.getId());
		
		favoriteService.addMovieToFavorite(favorite.getId_user(), favorite.getId_movie());

		ArrayList<String> as = favoriteService.getFavoriteMoviesListFromUser(user.getId());
		System.out.println(as.toString());
		
		// Watchlist
		 
		WatchList watchList = new WatchList();
		watchList.setId_movie(String.valueOf(movie.getId()));
		watchList.setId_user(user.getId());
		
		watchlistService.addWatchListToMovie(watchList.getId_user(), watchList.getId_movie());
		
		*/

		System.out.println("FIN");
	
	}

}
