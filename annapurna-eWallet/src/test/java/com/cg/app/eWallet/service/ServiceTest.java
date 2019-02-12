package com.cg.app.eWallet.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.app.eWallet.entity.EWallet;
import com.cg.app.eWallet.entity.Statement;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ServiceTest {
	@Autowired
	private EWalletService service;

	@Test
	public void checkingTheExistenceOfWallets() {
		List<EWallet> viewAllWallets = service.viewWallets();
		assertEquals(false, viewAllWallets.isEmpty());
	}

	@Test
	public void checkingForWalletBalance() {
		double ewallet = service.getWalletBalance(10);
		assertEquals(121, ewallet, 0);
	}

	@Test
	public void checkEWalletSize() {
		List<EWallet> ewalletSize = service.viewWallets();
		assertEquals(7, ewalletSize.size());
	}

	@Test
	public void checkNumberOfStatements() {
		List<Statement> checkStatements = service.getStatements();
		assertEquals(3, checkStatements.size());
	}

	@Test
	public void checkNumberOfStatementsById() {
		List<Statement> checkById = service.getStatementById(1);
		assertEquals(3, checkById.size());
	}

	@Test
	@Ignore
	public void addMoneyTest() {
		assertEquals(322, service.addMoney(10, 100), 0);

	}
}
