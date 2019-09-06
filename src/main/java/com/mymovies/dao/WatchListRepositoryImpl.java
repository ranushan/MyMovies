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

import com.mymovies.entity.WatchList;

@Repository
@Transactional
public class WatchListRepositoryImpl implements WatchListRepository{

	@Autowired
	private EntityManager em;
	
	@Override
	public ArrayList<String> getWatchListMoviesListFromUser(long userId) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<WatchList> query = builder.createQuery(WatchList.class);
		Root<WatchList> watchListRoot = query.from(WatchList.class);
		
		query.select(watchListRoot);
	
		query.where(builder.equal(watchListRoot.get("id_user"),userId));
			
		ArrayList<String> res = new ArrayList<String>();
		List<WatchList> watchListed = em.createQuery(query).getResultList();
		
		for(WatchList watchList : watchListed) {
			res.add(watchList.getId_movie());
		}
		
		return res;
		
	}

	@Override
	public void addWatchListToMovie(long userId, String movieId) {
		
		try {
			
			WatchList watchListMovie = new WatchList();
			watchListMovie.setId_user(userId);
			watchListMovie.setId_movie(movieId);
			
			em.persist(watchListMovie);
			em.flush();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}

	@Override
	public void removeWatchListToMovie(long userId, String movieId) {
		
		try {
			
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<WatchList> query = builder.createQuery(WatchList.class);
			Root<WatchList> watchListRoot = query.from(WatchList.class);

			query.select(watchListRoot);
			
			query.where(builder.equal(watchListRoot.get("id_user"),userId), builder.equal(watchListRoot.get("id_movie"),movieId));
			
			em.remove(query);
			
			em.flush();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}

	}

	@Override
	public EntityManager getEm() {
		return em;
	}

}
