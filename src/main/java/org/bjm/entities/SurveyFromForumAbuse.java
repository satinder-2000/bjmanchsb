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
public class SurveyFromForumAbuse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reportText;
    private int reportByAccessId;
    private String reportByEmail;
    private LocalDateTime reportedOn;
    private int surveyFromForumVoteId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReportText() {
		return reportText;
	}
	public void setReportText(String reportText) {
		this.reportText = reportText;
	}
	public int getReportByAccessId() {
		return reportByAccessId;
	}
	public void setReportByAccessId(int reportByAccessId) {
		this.reportByAccessId = reportByAccessId;
	}
	public String getReportByEmail() {
		return reportByEmail;
	}
	public void setReportByEmail(String reportByEmail) {
		this.reportByEmail = reportByEmail;
	}
	public LocalDateTime getReportedOn() {
		return reportedOn;
	}
	public void setReportedOn(LocalDateTime reportedOn) {
		this.reportedOn = reportedOn;
	}
	public int getSurveyFromForumVoteId() {
		return surveyFromForumVoteId;
	}
	public void setSurveyFromForumVoteId(int surveyFromForumVoteId) {
		this.surveyFromForumVoteId = surveyFromForumVoteId;
	}

       
}