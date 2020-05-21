package com.application.cities.controllers;

import com.application.cities.domain.City;
import com.application.cities.services.CityService;
import java.util.List;
import java.util.Optional;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/")
public class CityController {

  private CityService cityService;

  @Autowired
  public CityController(CityService storageService) {
    this.cityService = storageService;
  }

  @GetMapping(value = "/latest-created-city", produces = MediaType.APPLICATION_JSON_VALUE)
  public City latestCityCreated() {
    return cityService.readLatestCreatedCity();
  }

  @GetMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<City> citiesFromCountry(@RequestParam("country") String countryAbbreviation) {
    return cityService.readCitiesFromCountry(countryAbbreviation);
  }

  @GetMapping(
      value = "/city/{id}",
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<City> cityById(
      @PathVariable long id,
      @RequestHeader(required = false) Long delay
  ) {
    ResponseEntity<City> response = ResponseEntity.of(cityService.readCityById(id));
    Optional.ofNullable(delay).ifPresent(this::waitFor);
    return response;
  }

  @SneakyThrows
  private void waitFor(long delayMs) {
    Thread.sleep(delayMs);
  }

}
