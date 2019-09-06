package com.mymovies.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mymovies.controller.MovieController;
import com.mymovies.dto.MovieDTO;
import com.mymovies.entity.Favorite;

@Repository
@Transactional
public class FavoriteRepositoryImpl implements FavoriteRepository{

	@Autowired
	private EntityManager em;
	
	@Override
	public ArrayList<String> getFavoriteMoviesListFromUser(long userId) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Favorite> query = builder.createQuery(Favorite.class);
		Root<Favorite> favoriteRoot = query.from(Favorite.class);
		
		query.select(favoriteRoot);
	
		query.where(builder.equal(favoriteRoot.get("id_user"),userId));
			
		ArrayList<String> res = new ArrayList<String>();
		List<Favorite> favorites = em.createQuery(query).getResultList();
		
		for(Favorite fav : favorites) {
			res.add(fav.getId_movie());
		}
		
		return res;
		
	}

	@Override
	public void addMovieToFavorite(long userId, String movieId) {
		
		//Call tmdb api to get MovieDTO for movieID
		
		MovieController movieController = new MovieController();
		MovieDTO movieDTO = movieController.getAPI_Detail(movieId);
		
		//getFavirite or create favirite if dosent exist ( si elle existe dans les favorits ) 
		
		
		
		//if favorite is created //favoriteMovie.setId_user(userId);
	
		//favoriteMovie.getMovies().add(themovieDTOFromAPI Casted to Entity Movie
		try {
			
			Favorite favoriteMovie = new Favorite();
			//favoriteMovie.setId_user(userId);
			//favoriteMovie.setId_movie(movieId);
			
			em.persist(favoriteMovie);
			em.flush();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
	}

	@Override
	public void removeMovieToFavorite(long userId, String movieId) {
		
		// Verifie si il existe ( a verifier le code )
		
		try {
			
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Favorite> query = builder.createQuery(Favorite.class);
			Root<Favorite> favoriteRoot = query.from(Favorite.class);
			
			query.select(favoriteRoot);

			// 2 Manieres de faire Where
			
			query.where(builder.equal(favoriteRoot.get("id_user"),userId), builder.equal(favoriteRoot.get("id_movie"),movieId));
			
			/*
			query.where(
					builder.and(
							builder.equal(favoriteRoot.get("id_user"),userId),
							builder.equal(favoriteRoot.get("id_movie"),movieId)
					)
					
			);
			*/

			Favorite f = (Favorite) em.createQuery(query).getResultList().get(0);
			
			//System.out.println(em.createQuery(query).getResultList().toString());
			
			//System.out.println(f.toString());
			
			em.remove(f);
			em.flush();
				
				
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}

	}

	public EntityManager getEm() {
		return em;
	}
	
}
