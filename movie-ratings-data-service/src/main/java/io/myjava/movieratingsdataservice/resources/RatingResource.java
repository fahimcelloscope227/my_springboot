package io.myjava.movieratingsdataservice.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.myjava.movieratingsdataservice.models.Rating;

@RestController
@RequestMapping("rating-data")
public class RatingResource {
	
	@GetMapping("/{movieId}")
	public Rating getMovieRating(@PathVariable("movieId") String movieId) {
		
		return new Rating(movieId,4);
	}

}
