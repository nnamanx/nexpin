package com.nnamanx.nexpin.controller;

import com.nnamanx.nexpin.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;


}
