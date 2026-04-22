package org.bjm.entities;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class BlogAbuse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int blogCommentId;
	private String reportedText;
	private int reportedByAccessId;
	private String reportedByEmail;
	private LocalDateTime reportedOn;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBlogCommentId() {
		return blogCommentId;
	}
	public void setBlogCommentId(int blogCommentId) {
		this.blogCommentId = blogCommentId;
	}
	public String getReportedText() {
		return reportedText;
	}
	public void setReportedText(String reportedText) {
		this.reportedText = reportedText;
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
	public LocalDateTime getReportedOn() {
		return reportedOn;
	}
	public void setReportedOn(LocalDateTime reportedOn) {
		this.reportedOn = reportedOn;
	}
	
	

}
