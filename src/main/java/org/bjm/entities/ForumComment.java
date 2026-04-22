package org.bjm.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ForumComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String comment;
	private LocalDateTime dated;
	private int forumCommenterAccessId;
	private String forumCommenterEmail;
	private int forumId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getForumCommenterAccessId() {
		return forumCommenterAccessId;
	}
	public void setForumCommenterAccessId(int forumCommenterAccessId) {
		this.forumCommenterAccessId = forumCommenterAccessId;
	}
	public String getForumCommenterEmail() {
		return forumCommenterEmail;
	}
	public void setForumCommenterEmail(String forumCommenterEmail) {
		this.forumCommenterEmail = forumCommenterEmail;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	
	
}
