package dev.educosta.application.population;

import dev.educosta.application.population.domain.PopulationRepository;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.stream.StreamSupport;
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

  private final PopulationRepository repository;

  @Autowired
  public DataLoader(PopulationRepository repository) {
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
      StreamSupport.stream(parser.spliterator(), false)
          .filter(record -> !record.get("population").isEmpty())
          .forEach(record -> repository.add(
              Long.parseLong(record.get("id")),
              (long) Double.parseDouble(record.get("population"))
              )
          );
    }
  }


}