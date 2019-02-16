package com.cg.app.eWallet.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.eWallet.entity.EWallet;
import com.cg.app.eWallet.entity.Statement;
import com.cg.app.eWallet.service.EWalletService;

@RestController
@RequestMapping("/ewallets")
public class EWalletResource {
	@Autowired
	private EWalletService service;

	@GetMapping
	public List<EWallet> viewWallets() {
		return service.viewWallets();
	}

	@PutMapping("/{profileId}")
	public void addMoney(@PathVariable Integer profileId, @RequestParam("currentBalance") double amount) {
		service.addMoney(profileId, amount);
	}
	
	@PostMapping
	public void addwallet(@RequestBody EWallet eWallet) {
		service.addwallet(eWallet);
	}

	/*
	 * @PostMapping public void addwallet(@RequestParam Integer profileId) { EWallet
	 * ewallet = new EWallet(); ewallet.setProfileId(profileId);
	 * service.addwallet(ewallet); }
	 */

	@GetMapping("/{profileId}")
	public double getWalletBalance(@PathVariable Integer profileId) {
		double currentBalance = service.getWalletBalance(profileId);
		return currentBalance;
	}

	@PutMapping("/{profileId}/pay")
	public void passMoney(@PathVariable Integer profileId, @RequestParam("currentBalance") double amount) {
		service.passMoney(profileId, amount);
	}
	
	@GetMapping("/statements")
	public List<Statement> getStatements(){
		return service.getStatements();
	}
	
	@GetMapping("/statements/{profileId}")
	public List<Statement> getStatementById(@PathVariable Integer profileId) {
		return service.getStatementById(profileId);
	}
	
}
