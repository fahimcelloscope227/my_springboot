package io.myjava.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	
	private List<Topic>  allTopics = new ArrayList<>(Arrays.asList(
			new Topic("id1","JAva","description"),
			new Topic("id2","JAva1.8","description1.8"),
			new Topic("id3","JAva17","description17")
	  ));
	
	public List<Topic> getAllTopics() {
		
		return allTopics;
	}
	
	
	public Topic getTopic(String id) {
		
		return allTopics.stream().filter(e -> e.getId().equals(id)).findFirst().get();
	}
	
	
	
	public void addTopic(Topic topic) {
		allTopics.add(topic);
		
	}
	
	public List<Topic> updateTopic(Topic topic,String id) {
		for (int index = 0; index < allTopics.size(); index++) 
		{
			 Topic filteredTopic = allTopics.get(index);
			 if(filteredTopic.id.equals(id)) {
				 allTopics.set(index, topic);
				 
			 }
			
		}
		
		return allTopics;
		
	}
	
	public void deleteTopic(String id) {
		Topic filteredTopic = getTopic(id);
		allTopics.remove(filteredTopic);
	}

}
