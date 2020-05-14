package com.application.cities.jpa;

import com.application.cities.domain.factories.CityFactory;
import com.application.cities.jpa.repository.CityRepository;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.io.input.BOMInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

  private final CityRepository repository;

  @Autowired
  public DataLoader(CityRepository repository) {
    this.repository = repository;
  }

  public void run(ApplicationArguments args) throws IOException {
    if (repository.isEmpty()) {
      loadFromCSV();
    }
  }

  private void loadFromCSV() throws IOException {
    InputStream resourceAsStream = DataLoader.class.getResourceAsStream("/worldcities.csv");
    final Reader reader = new InputStreamReader(
        new BOMInputStream(resourceAsStream), StandardCharsets.UTF_8);
    try (resourceAsStream; reader; CSVParser parser = new CSVParser(reader,
        CSVFormat.EXCEL.withHeader())) {
      parser.forEach(record -> repository.save(CityFactory.from(record)));
    }
  }


}