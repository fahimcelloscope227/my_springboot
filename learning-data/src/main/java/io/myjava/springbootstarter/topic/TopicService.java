package io.myjava.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	

	
	public List<Topic> getAllTopics() {
		List<Topic> allTopics = new ArrayList<>();
		 topicRepository.findAll().forEach(allTopics::add);
		 return allTopics;
	}
	
	
	public Topic getTopic(String id) {
		return topicRepository.findById(id).get();
	}
	
	
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public List<Topic> updateTopic(Topic topic,String id) {
		topicRepository.save(topic);
		return getAllTopics();
		
	}
	
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}

}
