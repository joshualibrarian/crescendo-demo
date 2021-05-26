package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class YelpReviewsResponse {

	public List<YelpReview> reviews;

	public YelpReviewsResponse() {}

	public List<YelpReview> getReviews() {
		return reviews;
	}
	public void setReviews(List<YelpReview> reviews) {
		this.reviews = reviews;
	}

}
