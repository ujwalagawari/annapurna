package com.cg.app.AnnapurnaProfileService.resourceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.app.AnnapurnaProfileService.entity.Address;
//import com.cg.app.AnnapurnaProfileService.entity.Cart;
import com.cg.app.AnnapurnaProfileService.entity.Profile;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class ResourceTest {

	private Profile profileService;

	@Before
	public void setup() {

		profileService = new Profile(1, "sdgwrg", "bandi", 1996,
				new Address(11,"Gandhi Nagar", "hyderabad",507303, "Telangana", "India"), 1,
			"bandi@@", 9505L, "i dont know");

	}

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test @Ignore
	public void controllerIdentified() throws Exception {
		ResponseEntity<Profile> responseEntity = testRestTemplate.getForEntity("/profiless", Profile.class);
		System.out.println(responseEntity.getStatusCode());
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}

	@Test @Ignore
	public void addAccount() throws Exception {

		ResponseEntity<Profile> responseEntity = testRestTemplate.postForEntity("/profiless", profileService,Profile.class);
		System.out.println(responseEntity.getStatusCode());
		System.out.println(responseEntity.getBody());
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

	}

	@Test  @Ignore
	public void getAccount() throws Exception {

		ResponseEntity<Profile> responseEntity = testRestTemplate.getForEntity("/profiless/1", Profile.class,
				profileService);
		// System.out.println(responseEntity);
		System.out.println(responseEntity.getStatusCode());
		System.out.println(responseEntity.getClass());
		System.out.println(responseEntity.getBody());
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

	}

	@Test  @Ignore
	public void deleteAccount() {
		testRestTemplate.delete("/profiless/1");
		ResponseEntity<Profile> responseEntity = testRestTemplate.getForEntity("/profiless/1", Profile.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
	}
	@Test @Ignore
	public void testForUpdate() {
		
	    testRestTemplate.put("/profiless/1", profileService);
		
	    ResponseEntity<Profile> responseEntity = testRestTemplate.getForEntity("/profiless/1", Profile.class);
	    System.out.println(profileService.getEmailId());
	    System.out.println(responseEntity.getBody().getEmailId());
		assertEquals(profileService.getGender(), responseEntity.getBody().getGender());
	}
	
}
