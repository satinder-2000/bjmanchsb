package org.bjm.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int publishedByAccessId;
	private String publishedByEmail;
	private LocalDateTime publishedOn;
	private String summary;
	private String text;
	private String title;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPublishedByAccessId() {
		return publishedByAccessId;
	}
	public void setPublishedByAccessId(int publishedByAccessId) {
		this.publishedByAccessId = publishedByAccessId;
	}
	public String getPublishedByEmail() {
		return publishedByEmail;
	}
	public void setPublishedByEmail(String publishedByEmail) {
		this.publishedByEmail = publishedByEmail;
	}
	public LocalDateTime getPublishedOn() {
		return publishedOn;
	}
	public void setPublishedOn(LocalDateTime publishedOn) {
		this.publishedOn = publishedOn;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
