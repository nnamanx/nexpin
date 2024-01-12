package com.nnamanx.nexpin.controller;

import com.nnamanx.nexpin.model.entity.Services;
import com.nnamanx.nexpin.service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nexpin/services")
@RequiredArgsConstructor
public class ServicesController {

    private final ServicesService servicesService;

    @GetMapping
    public ResponseEntity<List<Services>> getAllServices() {

        List<Services> services = servicesService.getAllServices();
        return ResponseEntity.ok(services);
    }
}
