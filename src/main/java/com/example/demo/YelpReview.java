package com.example.demo;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAlias;

@Component
public class YelpReview {
	String id;
	short rating;
	YelpUser user;
	String text;
	@JsonAlias("time_created")
	String timeCreated;
	String url;
	
	public YelpReview() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public short getRating() {
		return rating;
	}
	public void setRating(short rating) {
		this.rating = rating;
	}
	public YelpUser getUser() {
		return user;
	}
	public void setUser(YelpUser user) {
		this.user = user;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
