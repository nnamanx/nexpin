package com.nnamanx.nexpin.reposiotry;

import com.nnamanx.nexpin.model.entity.Cashback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CashbackRepository extends JpaRepository<Cashback, Long> {

    List<Cashback> findByTransactionId(Long transactionId);

}
