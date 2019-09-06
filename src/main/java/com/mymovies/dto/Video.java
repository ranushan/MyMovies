package com.mymovies.dto;
/*

package com.mymovies.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Video {

	// Attributs
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "key")
	private String key;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "site")
	private String site;
	
	@Column(name = "size")
	private int size; // Allowed Values: 360, 480, 720, 1080
	
	@Column(name = "type")
	private String type; // Allowed Values: Trailer, Teaser, Clip, Featurette, Behind the Scenes, Bloopers
	
	//@OneToOne
	@ManyToOne
	private Videos videos;

	// Override toString
	
	@Override
	public String toString() {
		return "Video [id=" + id + ", key=" + key + ", name=" + name + ", site=" + site + ", size=" + size + ", type="
				+ type + ", videos=" + videos + "]";
	}
	
	// Constructor From SuperClass

	public Video() {
		super();
	}

	// Constructor Using Fields
	
	public Video(long id, String key, String name, String site, int size, String type, Videos videos) {
		super();
		this.id = id;
		this.key = key;
		this.name = name;
		this.site = site;
		this.size = size;
		this.type = type;
		this.videos = videos;
	}

	// Getters and Setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Videos getVideos() {
		return videos;
	}

	public void setVideos(Videos videos) {
		this.videos = videos;
	}
	
}

*/
