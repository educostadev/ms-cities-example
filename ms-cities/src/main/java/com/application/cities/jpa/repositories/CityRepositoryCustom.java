package com.application.cities.jpa.repositories;

import com.application.cities.jpa.entities.CityEntity;

public interface CityRepositoryCustom {

  CityEntity findLatestCityCreated();

  boolean isEmpty();

}
