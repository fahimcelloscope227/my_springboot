package io.myjava.movieratingsdataservice.models;

import java.util.List;

public class UserRatings {
	
	List<Rating> userRatings;
	
	public UserRatings() {}
	
	public UserRatings(List<Rating> userRatings) {
		super();
		this.userRatings = userRatings;
	}

	public List<Rating> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<Rating> userRatings) {
		this.userRatings = userRatings;
	}
	
	
	
	
}
