package dev.educosta.application.population.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class PopulationRepository {

  private Map<Long, Long> populationByCity = new HashMap<>();

  public void add(long cityId, long population) {
    this.populationByCity.put(cityId, population);
  }

  public Optional<Long> getPopulationFromCity(long cityId) {
    return Optional.ofNullable(this.populationByCity.get(cityId));
  }

}
