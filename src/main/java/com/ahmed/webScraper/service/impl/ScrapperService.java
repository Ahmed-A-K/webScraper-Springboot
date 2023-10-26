package com.ahmed.webScraper.service.impl;

import com.ahmed.webScraper.DTO.ResponseDTO;
import com.ahmed.webScraper.service.IScrapperService;
import io.micrometer.common.util.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class ScrapperService implements IScrapperService {

    @Value("${website.url}")
    private String url;

    @Override
    public Set<ResponseDTO> getVehicleByModel() throws IOException {
        System.out.println(url);
        Set<ResponseDTO> responseDTOS = new HashSet<>();
        extractDataFromTarget(responseDTOS,url);
        return responseDTOS;
    }

    public void extractDataFromTarget(Set<ResponseDTO> responseDTOS,String url) throws IOException {

        Document document = Jsoup.connect(url).userAgent("Mozilla/5.0").get();

        Elements elements = document.getElementsByTag("h3");

        for (Element ads: elements) {
            ResponseDTO responseDTO = new ResponseDTO();
                responseDTO.setTitle(ads.text());
                responseDTO.setUrl(url);
            if (responseDTO.getUrl() != null) responseDTOS.add(responseDTO);
        }
    }
}
