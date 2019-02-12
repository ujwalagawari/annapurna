package com.cg.app.AnnapurnaProfileService.entity;

import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Profile {

	Random random = new Random();

	//int rand = random.nextInt();
	@Id
	private int profileId=random.nextInt();
	private String profileImage;
	private String name;
	private int dateOfBirth;
	private Address address;
	private int cartId;
	private String EmailId;
	private Long phoneNumber;
	private String gender;
	
	public Profile() {
		super();
	}
	
	public Profile(int profileId, String profileImage, String name, int dateOfBirth, Address address, int cartId,
			String emailId, Long phoneNumber, String gender) {
		super();
		this.profileId = profileId;
		this.profileImage = profileImage;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.cartId = cartId;
		this.EmailId = emailId;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
	}


	public int getProfileId() {
		return profileId;
	}


	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}


	public String getProfileImage() {
		return profileImage;
	}


	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public String getEmailId() {
		return EmailId;
	}


	public void setEmailId(String emailId) {
		EmailId = emailId;
	}


	public Long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	
}