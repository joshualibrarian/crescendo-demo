package com.example.demo;

import org.springframework.stereotype.Component;
import com.jayway.jsonpath.JsonPath;

@Component
public class FaceAnnotations {

	public String joyLikelihood;
	public String sorrowLikelihood;
	public String angerLikelihood;
	public String surpriseLikelihood;
	public String underExposedLikelihood;
	public String blurredLikelihood;
	public String headwearLikelihood;

	public String getJoyLikelihood() {
		return joyLikelihood;
	}
	
	public void setJoyLikelihood(String joyLikelihood) {
		this.joyLikelihood = joyLikelihood;
	}
	
	public String getSorrowLikelihood() {
		return sorrowLikelihood;
	}
	
	public void setSorrowLikelihood(String sorrowLikelihood) {
		this.sorrowLikelihood = sorrowLikelihood;
	}
	
	public String getAngerLikelihood() {
		return angerLikelihood;
	}
	
	public void setAngerLikelihood(String angerLikelihood) {
		this.angerLikelihood = angerLikelihood;
	}
	
	public String getSurpriseLikelihood() {
		return surpriseLikelihood;
	}
	
	public void setSurpriseLikelihood(String surpriseLikelihood) {
		this.surpriseLikelihood = surpriseLikelihood;
	}
	
	public String getUnderExposedLikelihood() {
		return underExposedLikelihood;
	}
	
	public void setUnderExposedLikelihood(String underExposedLikelihood) {
		this.underExposedLikelihood = underExposedLikelihood;
	}
	
	public String getBlurredLikelihood() {
		return blurredLikelihood;
	}
	
	public void setBlurredLikelihood(String blurredLikelihood) {
		this.blurredLikelihood = blurredLikelihood;
	}
	
	public String getHeadwearLikelihood() {
		return headwearLikelihood;
	}

	public void setHeadwearLikelihood(String headwearLikelihood) {
		this.headwearLikelihood = headwearLikelihood;
	}

	public FaceAnnotations() {}
	
	public FaceAnnotations(String visionResponse) {
		System.out.println(visionResponse);
		joyLikelihood = JsonPath.parse(visionResponse).read("$..joyLikelihood");
		sorrowLikelihood = JsonPath.parse(visionResponse).read("$..sorrowLikelihood");
		angerLikelihood = JsonPath.parse(visionResponse).read("$..angerLikelihood");
		underExposedLikelihood = JsonPath.parse(visionResponse).read("$..underExposedLikelihood");
		blurredLikelihood = JsonPath.parse(visionResponse).read("$..blurredLikelihood");
		headwearLikelihood = JsonPath.parse(visionResponse).read("$..headwearLikelihood");
	}

}
