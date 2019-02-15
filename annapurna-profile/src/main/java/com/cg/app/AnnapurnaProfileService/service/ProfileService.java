package com.cg.app.AnnapurnaProfileService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.app.AnnapurnaProfileService.entity.Profile;

@Service
public interface ProfileService {

	
	
	Optional<Profile> getAccountById(int profileId);

	List<Profile> getAllElement();

	void deleteById(int profileId);

	Profile updateProfile(Profile profile);

	Profile addAccount(Profile profile);

	Profile findByUserName(String userName);

	
//	void addAccount(int profile);

}
