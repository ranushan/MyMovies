package com.mymovies.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WatchList implements Serializable{

	// Attributs
	
	private static final long serialVersionUID = -2872478832216276428L;

	@Id
	@Column(name = "id_user")
	private long id_user;
	
	@Id
	@Column(name = "id_movie", length = 100)
	private String id_movie;
	
	// Override toString
	
	@Override
	public String toString() {
		return "WatchList [id_user=" + id_user + ", id_movie=" + id_movie + "]";
	}

	// Constructor From SuperClass
	
	public WatchList() {
		super();
	}
	
	// Constructor Using Fields

	public WatchList(long id_user, String id_movie) {
		super();
		this.id_user = id_user;
		this.id_movie = id_movie;
	}

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

