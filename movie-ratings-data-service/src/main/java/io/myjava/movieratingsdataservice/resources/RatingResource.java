package io.myjava.movieratingsdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.myjava.movieratingsdataservice.models.UserRatings;
import io.myjava.movieratingsdataservice.models.Rating;


@RestController
@RequestMapping("rating-data")
public class RatingResource {

	@GetMapping("/{movieId}")
	public Rating getMovieRating(@PathVariable("movieId") String movieId) {

		return new Rating(movieId, 4);
	}

	@GetMapping("/users/{userId}")
	public UserRatings getUserRating(@PathVariable("userId") String userId) {

		List<Rating> ratings = Arrays.asList(new Rating("1234", 4),new Rating("5678", 3));

		UserRatings userRatings = new UserRatings();
		userRatings.setUserRatings(ratings);

		return userRatings;
	}

}
