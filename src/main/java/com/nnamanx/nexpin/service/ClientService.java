package com.nnamanx.nexpin.service;

import com.nnamanx.nexpin.model.entity.Client;

import java.util.List;

public interface ClientService {

    Client registerNewClient(Client client);
    Client updateClientDetails(Long clientId, Client client);
    void deleteClient(Long clientId);
    Client getClientById(Long clientId);
    List<Client> getAllClients();
    Client changePassword(Long clientId, String newPassword);
}
