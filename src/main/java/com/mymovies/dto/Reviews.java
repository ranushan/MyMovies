package com.mymovies.dto;
/*

package com.mymovies.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Reviews {

	// Attributs
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "page")
	private int page;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="reviews_movie", 
			joinColumns= { @JoinColumn(name= "reviews_id") },
			inverseJoinColumns = { @JoinColumn(name = "movie_id")}
			)
	private List<Movie> movie;
	
	@OneToOne
	private List<Review> review;
		
	@Column(name = "total_pages")
	private int total_pages;
	
	@Column(name = "total_results")
	private int total_results;

	// Override toString
	
	@Override
	public String toString() {
		return "Reviews [id=" + id + ", page=" + page + ", movie=" + movie + ", review=" + review + ", total_pages="
				+ total_pages + ", total_results=" + total_results + "]";
	}

	// Constructor From SuperClass
	
	public Reviews() {
		super();
	}

	// Constructor Using Fields
	
	public Reviews(long id, int page, List<Movie> movie, List<Review> review, int total_pages, int total_results) {
		super();
		this.id = id;
		this.page = page;
		this.movie = movie;
		this.review = review;
		this.total_pages = total_pages;
		this.total_results = total_results;
	}

	// Getters and Setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public int getTotal_results() {
		return total_results;
	}

	public void setTotal_results(int total_results) {
		this.total_results = total_results;
	}

}

*/
