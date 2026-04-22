package org.bjm.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author singh
 */
@Entity
public class SurveyFromForum{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String surveyCreatorEmail;
    private String categoryType;
    private String categorySubType;
    private String title;
    private String description;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private int forumId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSurveyCreatorEmail() {
		return surveyCreatorEmail;
	}
	public void setSurveyCreatorEmail(String surveyCreatorEmail) {
		this.surveyCreatorEmail = surveyCreatorEmail;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	public String getCategorySubType() {
		return categorySubType;
	}
	public void setCategorySubType(String categorySubType) {
		this.categorySubType = categorySubType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

       
}