package com.example.demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class DemoController {

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private Environment env;
	
	public DemoController() {
		
	}
	
	@RequestMapping(value = "/{yelpId}")
	public Mono<List<YelpReview>> getReviews(@PathVariable String yelpId) {
		String uri = "https://api.yelp.com/v3/businesses/" + yelpId + "/reviews";
		String apiKey = env.getProperty("demo.yelp.api_key");
		Mono<List<YelpReview>> response = webClientBuilder.build()
				.get()
				.uri(uri)
			    .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
			    .accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(YelpReviewsResponse.class)
				.flatMapIterable(yelpResponse -> yelpResponse.getReviews())
				//.map(review -> getVisionData(review))
				.collectList();
				
		
		return response;
	}
	
	
	// this is really not the proper way to do this, as there seems to be an official 
	// vision library for spring boot, however it was giving me dependecy issues, and 
	// this somewhat hacky approach basically works, except for an issue where google often (but not always)
	// can't fetch the image itself, so fails... the fix is to download the image and then 
	// upload it directly in base64, though at this point I decided I'd spent enough time on this
	// and hopefully you get the idea, and if this were a real project, I'd resolve those issues and use the 
	// proper spring vision libraries.
	
	public YelpReview getVisionData(YelpReview review) {
		String uri = "https://vision.googleapis.com/v1/images:annotate";
		String body = """
					{
					  "requests": [
					    {
					      "features": [
					        {
					          "maxResults": 10,
					          "type": "FACE_DETECTION"
					        }
					      ],
					      "image": {
					        "source": {
					          "imageUri": " """ + review.getUser().getProfileUrl() + """
"
					        }
					      }
					    }
					  ]
					}
					""";

			String apiKey = env.getProperty("demo.google.api_key");
			Mono<String> response = webClientBuilder.build()
					.post()
					.uri(uri)
					.header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
					.contentType(MediaType.APPLICATION_JSON)
					.bodyValue(body)
					.accept(MediaType.APPLICATION_JSON)
					.retrieve()
					.bodyToMono(String.class);
	
			response.subscribe(
					value -> review.getUser().setFaceAnnotations(new FaceAnnotations(value)),
					error -> error.printStackTrace(),
					() -> System.out.println("Google Vision API call never finished."));
			
		return review;
	}
	
}