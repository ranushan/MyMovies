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

import com.mymovies.entity.Rated;

@Repository
@Transactional
public class RatedRepositoryImpl implements RatedRepository{

	@Autowired
	private EntityManager em;
	
	@Override
	public ArrayList<String> getRatedMoviesListFromUser(long userId) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Rated> query = builder.createQuery(Rated.class);
		Root<Rated> ratedRoot = query.from(Rated.class);
		
		query.select(ratedRoot);
	
		query.where(builder.equal(ratedRoot.get("id_user"),userId));
			
		ArrayList<String> res = new ArrayList<String>();
		List<Rated> rated = em.createQuery(query).getResultList();
		
		for(Rated rate : rated) {
			res.add(rate.getId_movie());
		}
		
		return res;
		
	}

	@Override
	public void addRatedToMovie(long userId, String movieId) {
		
		// Verify if Rated already exist
		
		ArrayList<String> res = this.getRatedMoviesListFromUser(userId);
		
		for(String r : res) {
			if(movieId == r) {
				return;
			}
		}
		
		try {
			
			Rated ratedMovie = new Rated(userId, movieId);
			
			em.persist(ratedMovie);
			em.flush();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
	
	}

	@Override
	public void removeRatedToMovie(long userId, String movieId) {

		try {
			
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Rated> query = builder.createQuery(Rated.class);
			Root<Rated> ratedRoot = query.from(Rated.class);

			query.select(ratedRoot);

			query.where(builder.equal(ratedRoot.get("id_user"),userId), builder.equal(ratedRoot.get("id_movie"),movieId));
			
			Rated r = (Rated) em.createQuery(query).getResultList().get(0);
			
			em.remove(r);
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
