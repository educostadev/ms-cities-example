package com.application;

import com.application.geo.domain.GeoLocationFactory;
import com.application.geo.service.GeoLocationRepository;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.io.input.BOMInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

  private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

  private final GeoLocationRepository repository;

  @Autowired
  public DataLoader(GeoLocationRepository repository) {
    this.repository = repository;
  }

  public void run(ApplicationArguments args) throws IOException {
    logger.debug("Reading csf file to populate repository in memory...");
    loadFromCSV();
    logger.debug("Reading finished.");
  }

  private void loadFromCSV() throws IOException {
    InputStream resourceAsStream = DataLoader.class.getResourceAsStream("/worldcities.csv");
    final Reader reader = new InputStreamReader(
        new BOMInputStream(resourceAsStream), StandardCharsets.UTF_8);
    try (resourceAsStream; reader; CSVParser parser = new CSVParser(reader,
        CSVFormat.EXCEL.withHeader())) {
      parser.forEach(record -> repository.add(GeoLocationFactory.from(record)));
    }
  }


}