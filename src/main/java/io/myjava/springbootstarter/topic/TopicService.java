package io.myjava.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	
	private List<Topic>  allTopics = Arrays.asList(
			new Topic("id1","JAva","description"),
			new Topic("id2","JAva1.8","description1.8"),
			new Topic("id3","JAva17","description17")
	  );
	
	public List<Topic> getAllTopics() {
		
		return allTopics;
	}
	
	
	public Topic getTopic(String id) {
		
		return allTopics.stream().filter(e -> e.getId().equals(id)).findFirst().get();
	}
	

}
