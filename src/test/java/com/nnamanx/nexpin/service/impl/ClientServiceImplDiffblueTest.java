package com.nnamanx.nexpin.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.nnamanx.nexpin.exception.NoClientsFoundException;
import com.nnamanx.nexpin.model.entity.Client;
import com.nnamanx.nexpin.model.enums.Role;
import com.nnamanx.nexpin.reposiotry.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ClientServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ClientServiceImplDiffblueTest {
    @MockBean
    private ClientRepository clientRepository;

    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @MockBean
    private PasswordEncoder passwordEncoder;

    /**
     * Method under test: {@link ClientServiceImpl#updateClientParameter(Long, String, Object)}
     */
    @Test
    void testUpdateClientParameter() {
        Client client = new Client();
        client.setAccounts(new ArrayList<>());
        client.setFin("Fin");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setIs_active(true);
        client.setPassword("iloveyou");
        client.setPhoneNumber("6625550144");
        client.setRole(Role.CLIENT);
        client.setSerialNumber("42");
        Optional<Client> ofResult = Optional.of(client);
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertSame(client, clientServiceImpl.updateClientParameter(1L, "Field Name", "Updated Value"));
        verify(clientRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#updateClientParameter(Long, String, Object)}
     */
    @Test
    void testUpdateClientParameter2() {
        Optional<Client> emptyResult = Optional.empty();
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);
        assertThrows(UsernameNotFoundException.class,
                () -> clientServiceImpl.updateClientParameter(1L, "Field Name", "Updated Value"));
        verify(clientRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#updateClientParameter(Long, String, Object)}
     */
    @Test
    void testUpdateClientParameter3() {
        when(clientRepository.findById(Mockito.<Long>any())).thenThrow(new UsernameNotFoundException("Msg"));
        assertThrows(UsernameNotFoundException.class,
                () -> clientServiceImpl.updateClientParameter(1L, "Field Name", "Updated Value"));
        verify(clientRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#getClientById(Long)}
     */
    @Test
    void testGetClientById() {
        Client client = new Client();
        client.setAccounts(new ArrayList<>());
        client.setFin("Fin");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setIs_active(true);
        client.setPassword("iloveyou");
        client.setPhoneNumber("6625550144");
        client.setRole(Role.CLIENT);
        client.setSerialNumber("42");
        Optional<Client> ofResult = Optional.of(client);
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertSame(client, clientServiceImpl.getClientById(1L));
        verify(clientRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#getClientById(Long)}
     */
    @Test
    void testGetClientById2() {
        Optional<Client> emptyResult = Optional.empty();
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);
        assertThrows(UsernameNotFoundException.class, () -> clientServiceImpl.getClientById(1L));
        verify(clientRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#getClientById(Long)}
     */
    @Test
    void testGetClientById3() {
        when(clientRepository.findById(Mockito.<Long>any())).thenThrow(new UsernameNotFoundException("Msg"));
        assertThrows(UsernameNotFoundException.class, () -> clientServiceImpl.getClientById(1L));
        verify(clientRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#getAllClients()}
     */
    @Test
    void testGetAllClients() {
        when(clientRepository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(NoClientsFoundException.class, () -> clientServiceImpl.getAllClients());
        verify(clientRepository).findAll();
    }

    /**
     * Method under test: {@link ClientServiceImpl#getAllClients()}
     */
    @Test
    void testGetAllClients2() {
        Client client = new Client();
        client.setAccounts(new ArrayList<>());
        client.setFin("No clients found.");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setIs_active(true);
        client.setPassword("iloveyou");
        client.setPhoneNumber("6625550144");
        client.setRole(Role.CLIENT);
        client.setSerialNumber("42");

        ArrayList<Client> clientList = new ArrayList<>();
        clientList.add(client);
        when(clientRepository.findAll()).thenReturn(clientList);
        List<Client> actualAllClients = clientServiceImpl.getAllClients();
        assertSame(clientList, actualAllClients);
        assertEquals(1, actualAllClients.size());
        verify(clientRepository).findAll();
    }

    /**
     * Method under test: {@link ClientServiceImpl#getAllClients()}
     */
    @Test
    void testGetAllClients3() {
        when(clientRepository.findAll()).thenThrow(new UsernameNotFoundException("No clients found."));
        assertThrows(UsernameNotFoundException.class, () -> clientServiceImpl.getAllClients());
        verify(clientRepository).findAll();
    }

    /**
     * Method under test: {@link ClientServiceImpl#changePassword(Long, String)}
     */
    @Test
    void testChangePassword() {
        Client client = new Client();
        client.setAccounts(new ArrayList<>());
        client.setFin("Fin");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setIs_active(true);
        client.setPassword("iloveyou");
        client.setPhoneNumber("6625550144");
        client.setRole(Role.CLIENT);
        client.setSerialNumber("42");
        Optional<Client> ofResult = Optional.of(client);

        Client client2 = new Client();
        client2.setAccounts(new ArrayList<>());
        client2.setFin("Fin");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setIs_active(true);
        client2.setPassword("iloveyou");
        client2.setPhoneNumber("6625550144");
        client2.setRole(Role.CLIENT);
        client2.setSerialNumber("42");
        when(clientRepository.save(Mockito.<Client>any())).thenReturn(client2);
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
        assertSame(client2, clientServiceImpl.changePassword(1L, "iloveyou"));
        verify(clientRepository).save(Mockito.<Client>any());
        verify(clientRepository).findById(Mockito.<Long>any());
        verify(passwordEncoder).encode(Mockito.<CharSequence>any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#changePassword(Long, String)}
     */
    @Test
    void testChangePassword2() {
        Client client = new Client();
        client.setAccounts(new ArrayList<>());
        client.setFin("Fin");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setIs_active(true);
        client.setPassword("iloveyou");
        client.setPhoneNumber("6625550144");
        client.setRole(Role.CLIENT);
        client.setSerialNumber("42");
        Optional<Client> ofResult = Optional.of(client);
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenThrow(new UsernameNotFoundException("Msg"));
        assertThrows(UsernameNotFoundException.class, () -> clientServiceImpl.changePassword(1L, "iloveyou"));
        verify(clientRepository).findById(Mockito.<Long>any());
        verify(passwordEncoder).encode(Mockito.<CharSequence>any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#changePassword(Long, String)}
     */
    @Test
    void testChangePassword3() {
        Optional<Client> emptyResult = Optional.empty();
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);
        assertThrows(UsernameNotFoundException.class, () -> clientServiceImpl.changePassword(1L, "iloveyou"));
        verify(clientRepository).findById(Mockito.<Long>any());
    }
}

