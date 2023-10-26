package com.ahmed.webScraper.service.impl;

import com.ahmed.webScraper.DTO.ResponseDTO;
import com.ahmed.webScraper.service.IScrapperService;
import io.micrometer.common.util.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ScrapperService implements IScrapperService {

    @Value("${website.url}")
    private String url;

    @Override
    public Set<ResponseDTO> getVehicelByModel(String model) throws IOException {
        Set<ResponseDTO> responseDTOS = new HashSet<>();
        extractDataFromTarget(responseDTOS,url+model);
        return responseDTOS;
    }

    public void extractDataFromTarget(Set<ResponseDTO> responseDTOS,String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        Element element = document.getElementById("content");
        Elements elements = document.getElementsByTag("a");
        for (Element ads: elements) {
            ResponseDTO responseDTO = new ResponseDTO();

            if (!StringUtils.isEmpty(ads.attr("title")) ) {
                //mapping data to the model class
                responseDTO.setTitle(ads.attr("title"));
                responseDTO.setUrl(ads.attr("href"));
            }
            if (responseDTO.getUrl() != null) responseDTOS.add(responseDTO);
        }
    }
}
