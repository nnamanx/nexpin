package com.nnamanx.nexpin.service.impl;

import com.nnamanx.nexpin.model.entity.Client;
import com.nnamanx.nexpin.reposiotry.ClientRepository;
import com.nnamanx.nexpin.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {


    private final ClientRepository clientRepository;

    @Override
    public Client registerNewClient(Client client) {

        return null;
    }

    @Override
    public Client updateClientDetails(Long clientId, Client client) {

        Client client1 = clientRepository.findById(clientId).orElse(null);

        if (client1 != null) {

            if (client.getUsername() != null) client1.setUsername(client.getUsername());
            if (client.getEmail() != null) client1.setEmail(client.getEmail());

            clientRepository.save(client1);
        }else {

            throw new UsernameNotFoundException("User with id " + clientId + " not found");
        }

        return client;
    }

    @Override
    public void deleteClient(Long clientId) {

    }

    @Override
    public Client getClientById(Long clientId) {
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public Client changePassword(Long clientId, String newPassword) {
        return null;
    }
}
