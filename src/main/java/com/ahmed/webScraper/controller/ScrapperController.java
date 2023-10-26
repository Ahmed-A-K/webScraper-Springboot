package com.ahmed.webScraper.controller;

import com.ahmed.webScraper.DTO.ResponseDTO;
import com.ahmed.webScraper.service.impl.ScrapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ScrapperController {

    private final ScrapperService service;

    @GetMapping
    public Set<ResponseDTO> getVehicleById() throws IOException {
        return service.getVehicleByModel();
    }
}
