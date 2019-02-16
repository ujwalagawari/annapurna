package com.cg.app.AnnapurnaProfileService.resource;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.AnnapurnaProfileService.entity.Profile;
import com.cg.app.AnnapurnaProfileService.service.ProfileService;

@RestController
@RequestMapping("/profiless")
public class ProfileResource {

	
	
	@Autowired
	public ProfileService service;

	@GetMapping
	public List<Profile> getAllElements()//@PathVariable Profile profile)
	{
		return service.getAllElement();		
	}
	
	@PostMapping
	public Profile createAccount(@RequestBody Profile profile){		
		return service.addAccount(profile);	
	}
	
	@GetMapping("/{profileId}")
	 public ResponseEntity<Profile> getProfileById(@PathVariable Integer profileId)
    {
        Optional<Profile> profileobject = service.getAccountById(profileId);
        if (!profileobject.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(profileobject.get(), HttpStatus.OK);
    }
	
	@DeleteMapping("/{profileId}")
	public void deleteById(@PathVariable Integer profileId){
		service.deleteById(profileId);
	}
	
	@PutMapping("/{profileId}")
	public void updateProfile(@PathVariable int profileId,@RequestBody Profile profile2) {
		Optional<Profile> profileobject = service.getAccountById(profileId);
		Profile profile = profileobject.get();
		profile.setName(profile2.getName());
		profile.setEmailId(profile2.getEmailId());
		profile.setDateOfBirth(profile2.getDateOfBirth());
		profile.setGender(profile2.getGender());
		profile.setPhoneNumber(profile2.getPhoneNumber());
		profile.setUserName(profile2.getUserName());
		profile.getAddress().setArea(profile2.getAddress().getArea());
		profile.getAddress().setCity(profile2.getAddress().getCity());
		profile.getAddress().setCountry(profile2.getAddress().getCountry());
		profile.getAddress().setPincode(profile2.getAddress().getPincode());
		profile.getAddress().setState(profile2.getAddress().getState());
		service.updateProfile(profile);
	}
	
	@GetMapping("/login/{userName}")
	public ResponseEntity<Profile> updateProfile(@PathVariable String userName) {
		//System.out.println("profile user name "+userName);
		 Profile profile = service.findByUserName(userName);
		 return new ResponseEntity<>(profile, HttpStatus.OK);
	}

}
