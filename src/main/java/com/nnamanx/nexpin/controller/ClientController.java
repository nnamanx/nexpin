package com.nnamanx.nexpin.controller;

import com.nnamanx.nexpin.model.entity.Client;
import com.nnamanx.nexpin.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nexpin/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PatchMapping("/{clientId}")
    public ResponseEntity<Client> updateClientParameter(
            @PathVariable Long clientId,
            @RequestParam String fieldName,
            @RequestParam Object updatedValue
    ) {

        Client updatedClient = clientService.updateClientParameter(clientId, fieldName, updatedValue);
        return ResponseEntity.ok(updatedClient);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId) {

        Client client = clientService.getClientById(clientId);
        return ResponseEntity.ok(client);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {

        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @PostMapping("/{clientId}/change-password")
    public ResponseEntity<Client> changePassword(
            @PathVariable Long clientId,
            @RequestParam String newPassword
    ) {

        Client updatedClient = clientService.changePassword(clientId, newPassword);
        return ResponseEntity.ok(updatedClient);
    }


}
