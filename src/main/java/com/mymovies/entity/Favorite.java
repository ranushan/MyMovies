package com.mymovies.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Favorite implements Serializable{
	
	// Attributs
	
	private static final long serialVersionUID = -2646242663492943675L;

	@Id
	@Column(name = "userFavorite_id")
	private long id_user;
	
	@Id
	@Column(name = "movieFavorite_id", length = 100)
	private String id_movie;

	// Override toString
	
	@Override
	public String toString() {
		return "Favorite [id_user=" + id_user + ", id_movie=" + id_movie + "]";
	}

	// Constructor From SuperClass
	
	public Favorite() {
		super();
	}

	// Constructor Using Fields
	
	public Favorite(long id_user, String id_movie) {
		super();
		this.id_user = id_user;
		this.id_movie = id_movie;
	}

	// Getters and Setters
	
	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public String getId_movie() {
		return id_movie;
	}

	public void setId_movie(String id_movie) {
		this.id_movie = id_movie;
	}
	
}
