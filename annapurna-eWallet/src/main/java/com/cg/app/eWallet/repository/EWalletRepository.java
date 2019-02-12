package com.cg.app.eWallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.app.eWallet.entity.EWallet;
@Repository
public interface EWalletRepository extends JpaRepository<EWallet, Integer> {

}
