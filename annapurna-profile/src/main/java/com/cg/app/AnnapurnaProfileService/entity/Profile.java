package com.cg.app.AnnapurnaProfileService.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class Profile {

	@Id
	private int profileId;
	private String profileImage;
	private String name;
	private String userName;
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	private Address address;
	private int cartId;
	private String emailId;
	private Long phoneNumber;
	private String gender;
	private static int profileIdGenerator;
	static {
		profileIdGenerator=100;
	}
	{
		profileId=++profileIdGenerator;	
	}

	public Profile() {
		super();
		
	}

	public Profile(int profileId, String profileImage, String name,String userName,String password,LocalDate dateOfBirth, Address address, int cartId,
			String emailId, Long phoneNumber, String gender) {
		super();
		this.profileId=profileId ;
		this.profileImage = profileImage;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.cartId = cartId;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	
		this.gender = gender;
	}
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static int getProfileIdGenerator() {
		return profileIdGenerator;
	}

	public static void setProfileIdGenerator(int profileIdGenerator) {
		Profile.profileIdGenerator = profileIdGenerator;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
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
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
