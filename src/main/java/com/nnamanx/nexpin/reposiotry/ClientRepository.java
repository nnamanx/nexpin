package com.nnamanx.nexpin.reposiotry;

import com.nnamanx.nexpin.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
