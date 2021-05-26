package com.example.demo;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAlias;

@Component
public class YelpUser {
	String id;
	@JsonAlias("profile_url") String profileUrl;
	@JsonAlias("image_url") String imageUrl;
	String name;
	
	FaceAnnotations faceAnnotations;

	public YelpUser() {}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getProfileUrl() {
		return profileUrl;
	}
	
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public FaceAnnotations getFaceAnnotations() {
		return faceAnnotations;
	}

	public void setFaceAnnotations(FaceAnnotations faceAnnotations) {
		this.faceAnnotations = faceAnnotations;
	}
	
	
}
