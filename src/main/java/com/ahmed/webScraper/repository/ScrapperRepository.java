package com.ahmed.webScraper.repository;

import com.ahmed.webScraper.entity.Scraped;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrapperRepository extends JpaRepository<Scraped, Integer>{
}
