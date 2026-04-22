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
public class VidhanSabhaNominate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String candidateName;
    private String constituency;
    private int nominatedByAccessId;
    private String nominatedByEmail;
    private LocalDateTime nominatedOn;
    private int nominationCount;
    private String stateCode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	public int getNominatedByAccessId() {
		return nominatedByAccessId;
	}
	public void setNominatedByAccessId(int nominatedByAccessId) {
		this.nominatedByAccessId = nominatedByAccessId;
	}
	public String getNominatedByEmail() {
		return nominatedByEmail;
	}
	public void setNominatedByEmail(String nominatedByEmail) {
		this.nominatedByEmail = nominatedByEmail;
	}
	public LocalDateTime getNominatedOn() {
		return nominatedOn;
	}
	public void setNominatedOn(LocalDateTime nominatedOn) {
		this.nominatedOn = nominatedOn;
	}
	public int getNominationCount() {
		return nominationCount;
	}
	public void setNominationCount(int nominationCount) {
		this.nominationCount = nominationCount;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

        
}