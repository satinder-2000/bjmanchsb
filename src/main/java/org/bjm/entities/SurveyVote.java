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
public class SurveyVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;
    private LocalDateTime dated;
    private String voteType;
    private int surveyId;
    private int voterAccessId;
    private String voterEmail;
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
	public String getVoteType() {
		return voteType;
	}
	public void setVoteType(String voteType) {
		this.voteType = voteType;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public int getVoterAccessId() {
		return voterAccessId;
	}
	public void setVoterAccessId(int voterAccessId) {
		this.voterAccessId = voterAccessId;
	}
	public String getVoterEmail() {
		return voterEmail;
	}
	public void setVoterEmail(String voterEmail) {
		this.voterEmail = voterEmail;
	}
    
    

    
}