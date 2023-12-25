package com.nnamanx.nexpin.reposiotry;

import com.nnamanx.nexpin.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByUsername(String username); // The username might not exist in the database, so that we use Optional not to return NULLPOINTEREXCEPTION
}
