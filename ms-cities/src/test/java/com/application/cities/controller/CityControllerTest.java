package com.application.cities.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.application.cities.domain.City;
import com.application.cities.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(CityController.class)
@Slf4j
class CityControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  CityService service;

  @BeforeEach
  void before() {
    assertNotNull(mockMvc);
  }


  @Test
  void shouldReadLatestCity() throws Exception {

    City city = new City();
    city.setId(1L);
    city.setName("São Paulo");
    city.setCountry("Brazil");
    city.setCountryAbbreviation("BR");

    when(service.readLatestCreatedCity()).thenReturn(city);

    ResultActions resultActions = mockMvc.perform(get("/v1/latest-city")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(resultHandler ->
            log.debug("Response " + resultHandler.getResponse().getContentAsString())
        );

    resultActions
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(city.getId().intValue())))
        .andExpect(jsonPath("$.name", is(city.getName())))
    ;
  }


}
