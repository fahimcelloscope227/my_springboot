package io.myjava.moviecatalogservice.resources;

import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.myjava.moviecatalogservice.models.MovieCatalog;
import io.myjava.moviecatalogservice.models.MovieInfo;
import io.myjava.moviecatalogservice.models.Rating;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@GetMapping("/{userId}")
	public List<MovieCatalog> getCatalogs(String userId){
	
		
		
		
		List<Rating> ratings = Arrays.asList(
				new Rating("1234",4),
				new Rating("1234",5)
		);
		
		return ratings.stream().map(rating -> {
			MovieInfo movie = restTemplate.getForObject("http://localhost:8082/movieinfo/"+rating.getMovieId(), MovieInfo.class);
			
//			MovieInfo movie = webClientBuilder.build()
//			.get()
//			.uri("http://localhost:8082/movieinfo/"+rating.getMovieId())
//			.retrieve()
//			.bodyToMono(MovieInfo.class)
//			.block();
			
			return new  MovieCatalog(movie.getName(),"Description",rating.getRating());
		}).collect(Collectors.toList());
		
		
		
	}

}
