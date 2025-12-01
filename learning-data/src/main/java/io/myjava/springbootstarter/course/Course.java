package io.myjava.springbootstarter.course;

import io.myjava.springbootstarter.topic.Topic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Course {
	
	@Id
	private String id;
	private String name;
	private String descriptions;
	
	@ManyToOne
	private Topic topic;
	
	
	

	public Course() {
		
	}
	
	public Course(String id, String name, String descriptions,String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.descriptions = descriptions;
		this.topic = new Topic(topicId,"","");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	

	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
	

}
