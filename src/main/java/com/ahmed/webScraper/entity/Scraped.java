package com.ahmed.webScraper.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Scraped {
    @Id
    @GeneratedValue
    Integer id;

    @Column(name = "Capital")
    String capital;

    @Column(name = "Country")
    String country;

    @Column(name = "Population")
    String population;

    @Column(name = "Area")
    String area;

    @Column(name = "Url")
    String url;
}
