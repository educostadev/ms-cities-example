package com.application.cities;

import static org.assertj.core.api.Assertions.assertThat;

import com.application.cities.controller.CityController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.driver-class-name=org.h2.Driver",
    "spring.jpa.hibernate.ddl-auto=none",
    "spring.datasource.username=sa",
    "spring.datasource.password="
})
class CityApplicationTest {

  @Autowired
  CityController controller;

  @Test
  void contextLoads() {
    assertThat(controller).isNotNull();
  }
}
