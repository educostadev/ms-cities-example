package com.application.cities.jpa.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ms_cities")
public class CityEntity {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "city_name", nullable = false)
  private String name;

  @Column(name = "city_ascii", nullable = false)
  private String nameAscii;

  @Column(name = "country_name", nullable = false)
  private String country;

  @Column(name = "country_abbrev", nullable = false)
  private String countryAbbreviation;

  @Column(name = "creation_time", nullable = false)
  @CreationTimestamp
  private LocalDateTime creationTime;

}
