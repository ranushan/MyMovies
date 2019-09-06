package com.mymovies.dto;
/*

package com.mymovies.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Videos {

	// Attributs
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//@OneToOne --> A Verifier
	@OneToMany
	private List<Video> video;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="videos_movie", 
			joinColumns= { @JoinColumn(name= "videos_id") },
			inverseJoinColumns = { @JoinColumn(name = "movie_id")}
			)
	private List<Movie> movie;

	// Override toString
	
	@Override
	public String toString() {
		return "Videos [id=" + id + ", video=" + video + ", movie=" + movie + "]";
	}
	
	// Constructor From SuperClass
	
	public Videos() {
		super();
	}

	// Constructor Using Fields
	
	public Videos(long id, List<Video> video, List<Movie> movie) {
		super();
		this.id = id;
		this.video = video;
		this.movie = movie;
	}

	// Getters and Setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Video> getVideo() {
		return video;
	}

	public void setVideo(List<Video> video) {
		this.video = video;
	}

	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}
	
}

*/