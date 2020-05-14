package com.application.geo.controller;

import com.application.geo.domain.GeoLocation;
import com.application.geo.service.GeoLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geo")
public class GeoLocationController {

  @Autowired
  GeoLocationRepository repository;

  @GetMapping(value = "/city/{id}")
  ResponseEntity<GeoLocation> readGeoLocationByCityId(@PathVariable long id) {
    return ResponseEntity.of(repository.findByCityId(id));
  }

}
