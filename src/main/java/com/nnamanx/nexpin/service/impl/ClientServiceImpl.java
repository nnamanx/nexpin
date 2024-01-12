package com.nnamanx.nexpin.service.impl;

import com.nnamanx.nexpin.exception.NoClientsFoundException;
import com.nnamanx.nexpin.model.entity.Client;
import com.nnamanx.nexpin.reposiotry.ClientRepository;
import com.nnamanx.nexpin.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Client updateClientParameter(Long clientId, String fieldName, Object updatedValue) {
        Client existingClient = clientRepository.findById(clientId).orElse(null);

        if (existingClient != null) {
            try {

                Field fieldToUpdate = Client.class.getDeclaredField(fieldName);
                fieldToUpdate.setAccessible(true);

                fieldToUpdate.set(existingClient, updatedValue);

                // Saving new one
                clientRepository.save(existingClient);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // Handle exception
                e.printStackTrace();
            }
        } else {
            throw new UsernameNotFoundException("Client with id " + clientId + " not found");
        }
        return existingClient;
    }

    @Override
    public Client getClientById(Long clientId) {

        return clientRepository.findById(clientId)
                .orElseThrow(() -> new UsernameNotFoundException("Client with id " + clientId + " not found"));
    }

    @Override
    public List<Client> getAllClients() {

        List<Client> clients = clientRepository.findAll();

        if (clients.isEmpty()) {

            throw new NoClientsFoundException("No clients found.");
        }

        return clients;
    }

    @Override
    public Client changePassword(Long clientId, String newPassword) {

        Client existingClient = clientRepository.findById(clientId)
                .orElseThrow(() -> new UsernameNotFoundException("Client with id " + clientId + " not found"));

        existingClient.setPassword(passwordEncoder.encode(newPassword));
        return clientRepository.save(existingClient);
    }
}
