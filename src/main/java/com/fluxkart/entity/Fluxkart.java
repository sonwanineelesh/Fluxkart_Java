package com.fluxkart.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="fluxkart")
public class Fluxkart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	private String email;
	private String phoneNumber;

	private Integer linkedId;

	private String linkPrecedence;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	private LocalDateTime deletedAt;

//	@OneToOne(mappedBy = "fluxkart",fetch = FetchType.LAZY, cascade 
//	        = CascadeType.ALL)
//    private ContactResponse contactResponses;
//
//	
//	public ContactResponse getContactResponses() {
//		return contactResponses;
//	}
//
//	public void setContactResponses(ContactResponse contactResponses) {
//		this.contactResponses = contactResponses;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getLinkedId() {
		return linkedId;
	}

	public void setLinkedId(Integer linkedId) {
		this.linkedId = linkedId;
	}

	public String getLinkPrecedence() {
		return linkPrecedence;
	}

	public void setLinkPrecedence(String linkPrecedence) {
		this.linkPrecedence = linkPrecedence;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

	
	
}
