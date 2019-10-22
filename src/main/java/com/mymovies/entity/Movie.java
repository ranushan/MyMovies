package com.mymovies.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.mymovies.dto.GenreDTO;
import com.mymovies.dto.Production_CompaniesDTO;
import com.mymovies.dto.Production_CountriesDTO;
import com.mymovies.dto.Spoken_LanguagesDTO;

@Entity
public class Movie {
	
	// Status 
	public enum enumStatus {
		RUMORED("Rumored"), 
		PLANNED("Planned"), 
		In_Production("In Production"),
		Post_Production("Post Production"), 
		Released("Released"), 
		Canceled("Canceled");
		
		enumStatus(String v) {
			status = enumStatus.valueOf(v);
		}
	}
	
	// Attributs
	
	@Column(name = "adult")
	private boolean adult;
	
	@Column(name = "backdrop_path")
	private String backdrop_path;
	
	@Column(name = "belongs_to_collection",columnDefinition = "json")
	private String belongs_to_collection;
	
	@Column(name = "budget")
	private int budget;
	
	@Column(name = "genres")
	private ArrayList<GenreDTO> genres;
	
	@Column(name = "homepage")
	private String homepage;
	
	@Id
	@Column(name = "id_movies")
	private int id;
	
	@Min(value = 9)
	@Max(value = 9)
	@Column(name = "imdb_id")
	private String imdb_id; // minLength: 9 maxLength: 9
	
	@Column(name = "original_language")
	private String original_language;
	
	@Column(name = "original_title")
	private String original_title;
	
	@Column(name = "overview")
	private String overview;
	
	@Column(name = "poster_path")
	private String poster_path;
	
	@Column(name = "production_companies")
	private ArrayList<Production_CompaniesDTO> production_companies;
	
	@Column(name = "production_countries")
	private ArrayList<Production_CountriesDTO> production_countries;

	@Column(name = "release_date")
	private Date release_date;
	
	@Column(name = "revenue")
	private int revenue;
	
	@Column(name = "runtime")
	private int runtime;
	
	@Column(name = "spoken_languages")
	private ArrayList<Spoken_LanguagesDTO> spoken_languages;

	@Column(name = "status")
	private static enumStatus status; // Allowed Values: Rumored, Planned, In Production, Post Production, Released, Canceled
	
	@Column(name = "tagline")
	private String tagline;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "video")
	private boolean video;
	
	@Column(name = "vote_average")
	private Number vote_average;
	
	@Column(name = "vote_count")
	private int vote_count;
	
	@ManyToMany
	@JoinTable(
			  name = "Favorite",
			  joinColumns = @JoinColumn(name = "movieFavorite_id"),
			  inverseJoinColumns = @JoinColumn(name = "userFavorite_id"))
	private List<User> userFavorite = new ArrayList<User>();
	
	@ManyToMany
	@JoinTable(
			  name = "Watchlist",
			  joinColumns = @JoinColumn(name = "movieWatchlist_id"),
			  inverseJoinColumns = @JoinColumn(name = "userWatchlist_id"))
	private List<User> userWatchlist = new ArrayList<User>();
	
	
	// Override toString
	
	@Override
	public String toString() {
		return "MovieDTO [adult=" + adult + ", backdrop_path=" + backdrop_path + ", belongs_to_collection="
				+ belongs_to_collection + ", budget=" + budget + ", genres=" + genres + ", homepage=" + homepage
				+ ", id=" + id + ", imdb_id=" + imdb_id + ", original_language=" + original_language
				+ ", original_title=" + original_title + ", overview=" + overview + ", poster_path=" + poster_path
				+ ", production_companies=" + production_companies + ", production_countries=" + production_countries
				+ ", release_date=" + release_date + ", revenue=" + revenue + ", runtime=" + runtime
				+ ", spoken_languages=" + spoken_languages + ", status=" + status + ", tagline=" + tagline + ", title="
				+ title + ", video=" + video + ", vote_average=" + vote_average + ", vote_count=" + vote_count + "]";
	}

	// Constructor from SuperClass
	
	public Movie() {
		super();
	}
	
	// Constructor Using Fields

	public Movie(boolean adult, String backdrop_path, String belongs_to_collection, int budget,
			ArrayList<GenreDTO> genres, String homepage, int id, @Min(9) @Max(9) String imdb_id,
			String original_language, String original_title, String overview, String poster_path,
			ArrayList<Production_CompaniesDTO> production_companies,
			ArrayList<Production_CountriesDTO> production_countries, Date release_date, int revenue, int runtime,
			ArrayList<Spoken_LanguagesDTO> spoken_languages, String tagline, String title, boolean video,
			Number vote_average, int vote_count, ArrayList<User> userFavorite, ArrayList<User> userWatchlist) {
		super();
		this.adult = adult;
		this.backdrop_path = backdrop_path;
		this.belongs_to_collection = belongs_to_collection;
		this.budget = budget;
		this.genres = genres;
		this.homepage = homepage;
		this.id = id;
		this.imdb_id = imdb_id;
		this.original_language = original_language;
		this.original_title = original_title;
		this.overview = overview;
		this.poster_path = poster_path;
		this.production_companies = production_companies;
		this.production_countries = production_countries;
		this.release_date = release_date;
		this.revenue = revenue;
		this.runtime = runtime;
		this.spoken_languages = spoken_languages;
		this.tagline = tagline;
		this.title = title;
		this.video = video;
		this.vote_average = vote_average;
		this.vote_count = vote_count;
		this.userFavorite = userFavorite;
		this.userWatchlist = userWatchlist;
	}

	// Getters and Setters
	
	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public String getBackdrop_path() {
		return backdrop_path;
	}

	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}

	public String getBelongs_to_collection() {
		return belongs_to_collection;
	}

	public void setBelongs_to_collection(String belongs_to_collection) {
		this.belongs_to_collection = belongs_to_collection;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public ArrayList<GenreDTO> getGenres() {
		return genres;
	}

	public void setGenres(ArrayList<GenreDTO> genres) {
		this.genres = genres;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImdb_id() {
		return imdb_id;
	}

	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}

	public String getOriginal_language() {
		return original_language;
	}

	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}

	public String getOriginal_title() {
		return original_title;
	}

	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public ArrayList<Production_CompaniesDTO> getProduction_companies() {
		return production_companies;
	}

	public void setProduction_companies(ArrayList<Production_CompaniesDTO> production_companies) {
		this.production_companies = production_companies;
	}

	public ArrayList<Production_CountriesDTO> getProduction_countries() {
		return production_countries;
	}

	public void setProduction_countries(ArrayList<Production_CountriesDTO> production_countries) {
		this.production_countries = production_countries;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public ArrayList<Spoken_LanguagesDTO> getSpoken_languages() {
		return spoken_languages;
	}

	public void setSpoken_languages(ArrayList<Spoken_LanguagesDTO> spoken_languages) {
		this.spoken_languages = spoken_languages;
	}

	public static enumStatus getStatus() {
		return status;
	}

	public static void setStatus(enumStatus status) {
		Movie.status = status;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isVideo() {
		return video;
	}

	public void setVideo(boolean video) {
		this.video = video;
	}

	public Number getVote_average() {
		return vote_average;
	}

	public void setVote_average(Number vote_average) {
		this.vote_average = vote_average;
	}

	public int getVote_count() {
		return vote_count;
	}

	public void setVote_count(int vote_count) {
		this.vote_count = vote_count;
	}

	public List<User> getUserFavorite() {
		return userFavorite;
	}

	public void setUserFavorite(List<User> userFavorite) {
		this.userFavorite = userFavorite;
	}
	
	public void addUserFavorite(User userFavorite) {
		this.userFavorite.add(userFavorite);
	}
	
	public List<User> getUserWatchlist() {
		return userWatchlist;
	}

	public void setUserWatchlist(List<User> userWatchlist) {
		this.userWatchlist = userWatchlist;
	}
	
	public void addUserWatchlist(User userWatchlist) {
		this.userWatchlist.add(userWatchlist);
	}
	
	// HashCode and Equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Movie other = (Movie) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
