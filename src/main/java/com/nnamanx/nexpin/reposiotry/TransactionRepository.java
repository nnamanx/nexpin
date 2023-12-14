package com.nnamanx.nexpin.reposiotry;

import com.nnamanx.nexpin.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
