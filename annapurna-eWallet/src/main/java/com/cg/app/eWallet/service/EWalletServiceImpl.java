package com.cg.app.eWallet.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.eWallet.entity.EWallet;
import com.cg.app.eWallet.entity.Statement;
import com.cg.app.eWallet.repository.EWalletRepository;
import com.cg.app.eWallet.repository.Statementrepository;

@Service
public class EWalletServiceImpl implements EWalletService {
	@Autowired
	private EWalletRepository repository;

	@Autowired
	private Statementrepository repostmt;

	@Override
	public void addwallet(EWallet ewallet) {
		repository.save(ewallet);
	}

	@Override
	public double addMoney(Integer profileId, double amount) {
		EWallet ewallet = repository.findById(profileId).get();
		ewallet.setCurrentBalance(ewallet.getCurrentBalance() + amount);
		double balance = ewallet.getCurrentBalance();
		System.out.println(balance);
		repository.save(ewallet);
		Statement statement = new Statement();
		statement.setAmount(amount);
		statement.setDateTime(LocalDateTime.now());
		statement.setTransactionType("credit");
		statement.setTransactionRemarks("added");
		statement.setOrderId(1);
		statement.seteWallet(ewallet);
		repostmt.save(statement);
		double updatedBalance=ewallet.getCurrentBalance();
		return updatedBalance;
	}

	@Override
	public List<EWallet> viewWallets() {
		return repository.findAll();
	}

	@Override
	public double getWalletBalance(Integer profileId) {
		EWallet ewallet = repository.findById(profileId).get();
		double balance=ewallet.getCurrentBalance();
		return balance;

	}

	@Override 
	public double passMoney(Integer profileId, double amount) {
		EWallet ewallet = repository.findById(profileId).get();
		ewallet.setCurrentBalance(ewallet.getCurrentBalance() - amount);
		double balance = ewallet.getCurrentBalance();
		repository.save(ewallet);
		Statement statement = new Statement();
		statement.setAmount(amount);
		statement.setDateTime(LocalDateTime.now());
		statement.setTransactionType("debit");
		statement.setTransactionRemarks("withdraw");
		statement.setOrderId(1);
		statement.seteWallet(ewallet);
		repostmt.save(statement);
		double updatedBalance=ewallet.getCurrentBalance();
		return updatedBalance;

	}

	@Override
	public List<Statement> getStatements() {

		return repostmt.findAll();
	}

	@Override
	public List<Statement> getStatementById(Integer profileId) {
		EWallet wallet = repository.findById(profileId).get();
		return wallet.getStatement();
	}

}
