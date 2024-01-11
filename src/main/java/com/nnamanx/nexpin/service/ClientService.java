package com.nnamanx.nexpin.service;

import com.nnamanx.nexpin.model.entity.Client;

import java.util.List;

public interface ClientService {


    Client updateClientParameter(Long clientId, String fieldName, Object updatedValue);

   Client getClientById(Long clientId);

    List<Client> getAllClients();

    Client changePassword(Long clientId, String newPassword);
}
