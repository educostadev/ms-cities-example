package com.application.cities.jpa.repositories;

import com.application.cities.jpa.entities.CityEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long>, CityRepositoryCustom {

  List<CityEntity> findByCountryAbbreviation(String abbreviation);

}
