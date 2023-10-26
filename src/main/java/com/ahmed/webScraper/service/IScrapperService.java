package com.ahmed.webScraper.service;

import com.ahmed.webScraper.DTO.ResponseDTO;

import java.io.IOException;
import java.util.Set;

public interface IScrapperService {
    Set<ResponseDTO> getVehicleByModel() throws IOException;

}
