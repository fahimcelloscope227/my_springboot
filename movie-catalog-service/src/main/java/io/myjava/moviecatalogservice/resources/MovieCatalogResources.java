package io.myjava.moviecatalogservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.myjava.moviecatalogservice.models.MovieCatalog;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {
	
	@GetMapping("/{userId}")
	public List<MovieCatalog> getCatalogs(String userId){
		
		return Collections.singletonList(
				new MovieCatalog("Transformer", "Descriptions", 4)
		);
		
	}

}
