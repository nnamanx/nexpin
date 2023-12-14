package com.nnamanx.nexpin.reposiotry;

import com.nnamanx.nexpin.model.entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {
}
