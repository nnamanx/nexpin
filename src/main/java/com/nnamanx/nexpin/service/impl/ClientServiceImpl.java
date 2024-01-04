package com.nnamanx.nexpin.service.impl;

import com.nnamanx.nexpin.model.entity.Client;
import com.nnamanx.nexpin.reposiotry.ClientRepository;
import com.nnamanx.nexpin.service.ClientService;
import lombok.RequiredArgsConstructor;
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
        return null;
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
