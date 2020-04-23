package com.application.cities.domain.factories;

import com.application.cities.domain.City;
import com.application.cities.jpa.entities.CityEntity;
import org.apache.commons.csv.CSVRecord;

public class CityFactory {

  private CityFactory() {
  }

  public static City from(CityEntity cityEntity) {
    City city = new City();
    city.setName(cityEntity.getName());
    city.setId(cityEntity.getId());
    city.setCountryAbbreviation(cityEntity.getCountryAbbreviation());
    city.setCountry(cityEntity.getCountry());
    return city;
  }


  public static CityEntity from(CSVRecord record) {
    CityEntity entity = new CityEntity();
    entity.setId(Long.valueOf(record.get("id")));
    entity.setName(record.get("city"));
    entity.setNameAscii(record.get("city_ascii"));
    entity.setCountryAbbreviation(record.get("iso2"));
    entity.setCountry(record.get("country"));
    return entity;
  }
}
