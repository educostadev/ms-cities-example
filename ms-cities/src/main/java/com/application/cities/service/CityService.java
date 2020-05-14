package com.application.cities.service;

import com.application.cities.dao.CityDao;
import com.application.cities.domain.City;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CityService {

  private final CityDao cityDao;

  @Autowired
  public CityService(CityDao cityDao) {
    this.cityDao = cityDao;
  }

  public City readLatestCreatedCity() {
    return cityDao.readLatestCreatedCity();
  }

  public List<City> readCitiesFromCountry(String countryAbbreviation) {
    return cityDao.readCitiesFromCountry(countryAbbreviation);
  }

  public Optional<City> readCityById(long id) {
    return cityDao.readCityById(id);
  }
}
