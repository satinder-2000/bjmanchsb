package org.bjm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

/**
 *
 * @author singh
 */
@Entity
public class SurveyAbuse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reportText;
    private int reportedByAccessId;
    private String reportedByEmail;
    private LocalDateTime reportedOn;
    private int surveyVoteId;
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
	public int getSurveyVoteId() {
		return surveyVoteId;
	}
	public void setSurveyVoteId(int surveyVoteId) {
		this.surveyVoteId = surveyVoteId;
	}

       
}