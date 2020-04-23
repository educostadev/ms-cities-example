package com.application.cities.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.application.cities.jpa.entities.CityEntity;
import com.application.cities.domain.City;
import com.application.cities.jpa.repository.CityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
public class CityDaoTest {

  @Container
  public static PostgreSQLContainer postgreSQLContainer = CustomPostgresContainer.getInstance();

  @Autowired
  private CityDao cityDao;

  @Autowired
  private CityRepository cityRepository;


  @Test
  void injectedComponentsAreNotNull() {
    assertNotNull(cityDao);
  }


  @Test
  public void readLatestCity() {
    CityEntity cityEntity2 = new CityEntity();
    cityEntity2.setId(2L);
    cityEntity2.setName("Rio de Janeiro");
    cityEntity2.setCountry("Brazil");
    cityEntity2.setCountryAbbreviation("BR");
    cityEntity2.setNameAscii("Sao Paulo");
    cityRepository.save(cityEntity2);

    CityEntity cityEntity1 = new CityEntity();
    cityEntity1.setId(1L);
    cityEntity1.setName("São Paulo");
    cityEntity1.setCountry("Brazil");
    cityEntity1.setCountryAbbreviation("BR");
    cityEntity1.setNameAscii("Sao Paulo");
    cityRepository.save(cityEntity1);

    City city = cityDao.readLatestCreatedCity();

    assertEquals(1L, city.getId());
  }

}
