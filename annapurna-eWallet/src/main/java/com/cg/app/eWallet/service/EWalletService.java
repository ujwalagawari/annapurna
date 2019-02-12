package com.cg.app.eWallet.service;

import java.util.List;
import java.util.Optional;

import com.cg.app.eWallet.entity.EWallet;
import com.cg.app.eWallet.entity.Statement;

public interface EWalletService {

	List<EWallet> viewWallets();

	double addMoney(Integer profileId, double amount);

	void addwallet(EWallet ewallet);

	double getWalletBalance(Integer profileId);

	double passMoney(Integer profileId, double amount);

	List<Statement> getStatements();

	List<Statement> getStatementById(Integer profileId);

	

}
