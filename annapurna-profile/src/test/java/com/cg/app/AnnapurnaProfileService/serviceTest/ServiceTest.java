package com.cg.app.AnnapurnaProfileService.serviceTest;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.app.AnnapurnaProfileService.entity.Address;
//import com.cg.app.AnnapurnaProfileService.entity.Cart;
import com.cg.app.AnnapurnaProfileService.entity.Profile;
import com.cg.app.AnnapurnaProfileService.service.ProfileService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

	@Autowired
	ProfileService service;

	@Test
	@Ignore
	public void testForGetAllElements() {
		// service.deleteById(0);
		List<Profile> getAllElementsObject = service.getAllElement();
		System.out.println(getAllElementsObject);

		assertEquals(0, getAllElementsObject.size());

	}

	@Test
	@Ignore
	public void testForGetAccountById() {
		Optional<Profile> getAccountByIdObject = service.getAccountById(1);
		assertEquals(false, getAccountByIdObject.isPresent());

	}

	@Test
	@Ignore
	public void testForDelete() {
		service.deleteById(1);
		Optional<Profile> getAccountByIdObject = service.getAccountById(1);
		assertEquals(false, getAccountByIdObject.isPresent());

	}

	@Test
	@Ignore
	public void testForDelateAndCheckSize() {
		List<Profile> getAllElementsObject = service.getAllElement();
		service.deleteById(1);
		assertEquals(0, getAllElementsObject.size());
	}

	@Test
	@Ignore
	public void testForAddingAccount() {

		Profile profile = new Profile(1, "imagehere", "bhanu bandi", 1996,
				new Address(11, "Gandhi Nagar", "hyderabad",507303, "Telangana", "India"), 1, "bhanu@Gai", 9505L,
				"M");

		Profile profiles = service.addAccount(profile);

		assertEquals(profile, profiles);

	}

	@Test
	@Ignore
	public void testForUpdate() {
		Profile profile=new Profile(1, "imagehere", "bhanu bandi", 1996,
				new Address(11, "Gandhi Nagar", "hyderabad", 507303, "Telangana", "India"), 1, "bandi@@", 9505L,
				"i dont know");
		profile.setEmailId("bandi@@");
		profile.setGender("F");
		Profile profiles = service.updateProfile(profile);
		assertEquals(profile, profiles);

	}
}
