package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * WARNING: Configure the environment variables for database connection first. See the file
 * application.yml and README.md
 */
@SpringBootApplication
public class CityApplication {

  public static void main(String[] args) {
    SpringApplication.run(CityApplication.class, args);
  }

}
