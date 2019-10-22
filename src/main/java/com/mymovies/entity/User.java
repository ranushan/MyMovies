package com.mymovies.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class User {
	
	// Attributs
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "username")
	private String username; 
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "email")
	private String email; 
		
	@Column(name = "image")
	private String image;
	
	@Column(name = "age")
	private int age;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "userFavorite")
	private List<Movie> favoriteMovie = new ArrayList<Movie>();
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "userWatchlist")
	private List<Movie> watchlistMovie = new ArrayList<Movie>();
	
	// Override toString
	
	@Override
	public String toString() {
		return "User [id=" + id + ", role=" + role + ", username=" + username + ", password=" + password + ", name="
				+ name + ", firstname=" + firstname + ", email=" + email + ", image=" + image + ", age=" + age + ", favoriteMovie=" + favoriteMovie + ", watchlistMovie=" + watchlistMovie + "]";
	}
	
	// Constructor From SuperClass
	
	public User() {
		super();
	}

	// Constructor Using Fields
	
	public User(long id, String role, String username, String password, String name, String firstname, String email,
			String image, int age, ArrayList<Movie> favoriteMovie, ArrayList<Movie> watchlistMovie) {
		super();
		this.id = id;
		this.role = role;
		this.username = username;
		this.password = password;
		this.name = name;
		this.firstname = firstname;
		this.email = email;
		this.image = image;
		this.age = age;
		this.favoriteMovie = favoriteMovie;
		this.watchlistMovie = watchlistMovie;
	}
	
	// Getters and Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Movie> getFavoriteMovie() {
		return favoriteMovie;
	}

	public void setFavoriteMovie(List<Movie> favoriteMovie) {
		this.favoriteMovie = favoriteMovie;
	}
	
	public void addFavoriteMovie(Movie favoriteMovie) {
		this.favoriteMovie.add(favoriteMovie);
		favoriteMovie.addUserFavorite(this);
	}
	
	public List<Movie> getWatchlistMovie() {
		return watchlistMovie;
	}

	public void setWatchlistMovie(List<Movie> watchlistMovie) {
		this.watchlistMovie = watchlistMovie;
	}
	
	public void addWatchlistMovie(Movie watchlistMovie) {
		this.watchlistMovie.add(watchlistMovie);
		watchlistMovie.addUserFavorite(this);
	}
	
	// HashCode and Equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
