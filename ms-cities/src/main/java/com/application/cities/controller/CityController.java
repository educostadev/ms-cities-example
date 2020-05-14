package com.application.cities.controller;

import com.application.cities.domain.City;
import com.application.cities.service.CityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/v1")
public class CityController {

  private CityService cityService;

  @Autowired
  public CityController(CityService storageService) {
    this.cityService = storageService;
  }

  @GetMapping(value = "/latest-created-city", produces = MediaType.APPLICATION_JSON_VALUE)
  City latestCityCreated() {
    return cityService.readLatestCreatedCity();
  }

  @GetMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
  List<City> citiesFromCountry(@RequestParam("country") String countryAbbreviation) {
    return cityService.readCitiesFromCountry(countryAbbreviation);
  }

  @GetMapping(value = "/city/{id}")
  ResponseEntity<City> cityById(@PathVariable long id) {
    return ResponseEntity.of(cityService.readCityById(id));
  }

}
