package com.nnamanx.nexpin.reposiotry;

import com.nnamanx.nexpin.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>{
}
