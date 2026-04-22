package org.bjm.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LokSabhaNominate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String candidateName;
	private int nominatedByAccessId;
	private String nominatedByEmail;
	private LocalDateTime nominatedOn;
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
	
	
	

}
