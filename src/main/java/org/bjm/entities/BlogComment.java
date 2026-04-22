package org.bjm.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BlogComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int blogCommenterAccessId;
	private String blogCommenterEmail;
	private int blogId;
	private String comment;
	private LocalDateTime dated;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBlogCommenterAccessId() {
		return blogCommenterAccessId;
	}
	public void setBlogCommenterAccessId(int blogCommenterAccessId) {
		this.blogCommenterAccessId = blogCommenterAccessId;
	}
	public String getBlogCommenterEmail() {
		return blogCommenterEmail;
	}
	public void setBlogCommenterEmail(String blogCommenterEmail) {
		this.blogCommenterEmail = blogCommenterEmail;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDateTime getDated() {
		return dated;
	}
	public void setDated(LocalDateTime dated) {
		this.dated = dated;
	}
	
	

}
