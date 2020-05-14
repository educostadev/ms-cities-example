package com.application.geo.service;

import com.application.geo.domain.GeoLocation;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class GeoLocationRepository {

  private Map<Long, GeoLocation> geoLocations = new HashMap<>();

  public Optional<GeoLocation> findByCityId(long cityId) {
    return Optional.ofNullable(this.geoLocations.get(cityId));
  }

  public void add(GeoLocation geoLocation) {
    this.geoLocations.put(geoLocation.getCityId(), geoLocation);
  }

}
