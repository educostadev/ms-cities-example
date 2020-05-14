package com.application.geo.domain;

import org.apache.commons.csv.CSVRecord;

public class GeoLocationFactory {

  public static GeoLocation from(CSVRecord record) {
    return new GeoLocation(
        Long.parseLong(record.get("id")),
        Double.parseDouble(record.get("lat")),
        Double.parseDouble(record.get("lng"))
    );
  }

}
