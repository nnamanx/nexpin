package com.nnamanx.nexpin.reposiotry;

import com.nnamanx.nexpin.model.entity.Account;
import com.nnamanx.nexpin.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long>{

    List<Account> findByClientId(Long clientId);

}
