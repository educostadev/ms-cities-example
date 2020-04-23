package com.application.cities.jpa.repository;

import com.application.cities.jpa.entities.CityEntity;

public interface CityRepositoryCustom {

  CityEntity findLatestCityCreated();

  boolean isEmpty();

}
