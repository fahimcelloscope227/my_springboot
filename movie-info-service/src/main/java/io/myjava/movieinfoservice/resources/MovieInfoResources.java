package io.myjava.movieinfoservice.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.myjava.movieinfoservice.models.MovieInfo;

@RestController
@RequestMapping("/movieinfo")
public class MovieInfoResources {
	
	
	@GetMapping("/{movieId}")
	public MovieInfo getMovieInfo(@PathVariable("movieId") String movieId) {
		return new MovieInfo(movieId,"Test Name");
	}

}
