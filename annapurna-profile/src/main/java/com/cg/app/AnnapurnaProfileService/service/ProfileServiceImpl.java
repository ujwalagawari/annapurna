package com.cg.app.AnnapurnaProfileService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.AnnapurnaProfileService.entity.Profile;
import com.cg.app.AnnapurnaProfileService.repository.ProfileRepository;


@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	private ProfileRepository repository;

//	@Override
//	public void addAccount(Profile profile) {
//		repository.save(profile);
//
//	}

	@Override
	public Optional<Profile> getAccountById(int profileId) {
	
		return repository.findById(profileId);
	}

	@Override
	public List<Profile> getAllElement() {
		
		return repository.findAll();

	}

	@Override
	public void deleteById(int profileId) {
		
		repository.deleteById(profileId);
	}

	@Override
	public Profile updateProfile(Profile profile) {
		
		//Profile profiles=new Profile();
		//System.out.println(profile.getDateOfBirth());
		//profiles
//		profile.setGender("i dont know");
//		profile.setEmailId("bandi@");
		return(repository.save(profile));
		}

	@Override
	public Profile addAccount(Profile profile) {
		// TODO Auto-generated method stub

     return(repository.save(profile));
	}

	


}
