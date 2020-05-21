package com.application.controllers;

import com.application.domain.City;
import com.application.services.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BFFController {

  @Autowired
  CitiesService citiesService;

  @GetMapping(path = "/city/{cityId}")
  ResponseEntity<City> readCity(
      @PathVariable long cityId,
      @RequestHeader(required = false) Long delay
  ) {
    return ResponseEntity.ok(citiesService.readCity(cityId,delay));
  }

}
