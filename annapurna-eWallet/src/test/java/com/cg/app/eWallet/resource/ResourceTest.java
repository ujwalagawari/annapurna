package com.cg.app.eWallet.resource;

import static org.junit.Assert.assertEquals;

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

import com.cg.app.eWallet.entity.EWallet;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ResourceTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

//TestForGetAllWallets
	@Test
	public void TestForGetAll() {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/ewallets", String.class);
		assertEquals(responseEntity.getStatusCode(), (HttpStatus.OK));
	}

//FailConditionForGetAllWallets
	@Test
	public void FailTestForGetAll() {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/ewallet", String.class);
		assertEquals(responseEntity.getStatusCode(), (HttpStatus.NOT_FOUND));
		System.out.println(responseEntity.getStatusCode());
	}

//TestForWalletBalance
	@Test
	public void testForGetWallet() {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/ewallets/1", String.class);
		assertEquals(responseEntity.getStatusCode(), (HttpStatus.OK));
	}

	@Test
	public void testForGetWalletForWrongURl() {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/ewallet/13", String.class);
		assertEquals(responseEntity.getStatusCode(), (HttpStatus.NOT_FOUND));
	}

//TestForAddWalletAccount
	@Test
	public void testForAddWalletAccount() {
		EWallet ewallet = new EWallet(10, 121.0, null);
		ResponseEntity<String> responseEntity = testRestTemplate.postForEntity("/ewallets", ewallet, String.class);
		assertEquals(responseEntity.getStatusCode(), (HttpStatus.OK));
	}

	@Test
	public void testForAddWalletAccountForWrongUrl() {
		EWallet ewallet = new EWallet(10, 121.0, null);
		ResponseEntity<String> responseEntity = testRestTemplate.postForEntity("/ewallet", ewallet, String.class);
		assertEquals(responseEntity.getStatusCode(), (HttpStatus.NOT_FOUND));
	}
	/*
	 * @Test public void testForAddMoney() { EWallet ewallet = new EWallet(10,
	 * 121.0, null); ResponseEntity<String> responseEntity =
	 * testRestTemplate.pu("/ewallet", ewallet, String.class); }
	 */
		
	
}
