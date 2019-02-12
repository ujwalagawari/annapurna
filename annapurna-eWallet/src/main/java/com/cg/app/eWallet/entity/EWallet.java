package com.cg.app.eWallet.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class EWallet {
	
	@Id
	private Integer profileId;
	private Double currentBalance;
	@OneToMany(mappedBy = "eWallet")
	@JsonManagedReference
	private List<Statement> statement;

	public EWallet(Integer profileId, Double currentBalance, List<Statement> statement) {
		super();
		this.profileId = profileId;
		this.currentBalance = currentBalance;
		this.statement = statement;
	}

	public EWallet() {
	}

	public EWallet(Integer profileId, Double currentBalance) {
		super();
		this.profileId = profileId;
		this.currentBalance = currentBalance;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public List<Statement> getStatement() {
		return statement;
	}

	public void setStatement(List<Statement> statement) {
		this.statement = statement;
	}

	@Override
	public String toString() {
		return "EWallet [profileId=" + profileId + ", currentBalance=" + currentBalance + ", statement=" + statement
				+ "]";
	}

}
