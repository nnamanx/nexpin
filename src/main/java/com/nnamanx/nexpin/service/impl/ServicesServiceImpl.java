package com.nnamanx.nexpin.service.impl;

import com.nnamanx.nexpin.model.entity.Services;
import com.nnamanx.nexpin.reposiotry.ServicesRepository;
import com.nnamanx.nexpin.service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesServiceImpl implements ServicesService {

    private final ServicesRepository servicesRepository;

    @Override
    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }

}
