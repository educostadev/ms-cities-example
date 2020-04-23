package com.application.cities.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class City {

  private Long id;
  private String name;
  private String country;
  private String countryAbbreviation;

}
