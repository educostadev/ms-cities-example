package com.application.cities.dao;

import com.application.cities.exceptions.NotFoundException;
import com.application.cities.jpa.entities.CityEntity;
import com.application.cities.domain.City;
import com.application.cities.domain.factories.CityFactory;
import com.application.cities.jpa.repository.CityRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao {

  private final CityRepository cityRepository;

  @Autowired
  public CityDao(CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  public City readLatestCreatedCity() {
    try {
      CityEntity cityEntity = cityRepository.findLatestCityCreated();
      return CityFactory.from(cityEntity);
    } catch (EmptyResultDataAccessException ex) {
      throw new NotFoundException("User Policy not found!", ex);
    }
  }

  public List<City> readCitiesFromCountry(String countryAbbreviation) {
    return cityRepository.findByCountryAbbreviation(countryAbbreviation)
        .stream().map(CityFactory::from)
        .collect(Collectors.toList());
  }
}
