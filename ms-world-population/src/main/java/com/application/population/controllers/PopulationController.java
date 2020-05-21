package com.application.population.controllers;

import com.application.population.domain.PopulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/population")
public class PopulationController {

  @Autowired
  PopulationRepository populationRepository;

  @GetMapping(path = "/city/{cityId}")
  public ResponseEntity<Long> getPopulationByCity(@PathVariable long cityId) {
    return ResponseEntity.of(populationRepository.getPopulationFromCity(cityId));
  }

}
