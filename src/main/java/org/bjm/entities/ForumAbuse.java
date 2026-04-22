package org.bjm.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ForumAbuse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int forumCommentId;
	private int reportedByAccessId;
	private String reportedByEmail;
	private String reportText;
	private LocalDateTime reportedOn;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getForumCommentId() {
		return forumCommentId;
	}
	public void setForumCommentId(int forumCommentId) {
		this.forumCommentId = forumCommentId;
	}
	public int getReportedByAccessId() {
		return reportedByAccessId;
	}
	public void setReportedByAccessId(int reportedByAccessId) {
		this.reportedByAccessId = reportedByAccessId;
	}
	public String getReportedByEmail() {
		return reportedByEmail;
	}
	public void setReportedByEmail(String reportedByEmail) {
		this.reportedByEmail = reportedByEmail;
	}
	public String getReportText() {
		return reportText;
	}
	public void setReportText(String reportText) {
		this.reportText = reportText;
	}
	public LocalDateTime getReportedOn() {
		return reportedOn;
	}
	public void setReportedOn(LocalDateTime reportedOn) {
		this.reportedOn = reportedOn;
	}
	
	
	
	

}
