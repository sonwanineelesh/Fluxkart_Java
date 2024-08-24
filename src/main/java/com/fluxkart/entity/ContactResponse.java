package com.fluxkart.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="contact")
public class ContactResponse {
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//@Column(name = "primaryContactId", nullable = false)
    private Integer primaryContactId=0;
    private List<String> email;
    private List<String> phoneNumber;
    private List<Integer> secondaryContactId;
 
 
	public Integer getPrimaryContactId() {
		return primaryContactId;
	}

	public void setPrimaryContactId(Integer primaryContactId) {
		this.primaryContactId = primaryContactId;
	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	public List<String> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Integer> getSecondaryContactId() {
		return secondaryContactId;
	}

	public void setSecondaryContactId(List<Integer> secondaryContactId) {
		this.secondaryContactId = secondaryContactId;
	}

	// Getters and Setters
    

}

