package com.application.cities.dao;

import org.testcontainers.containers.PostgreSQLContainer;

public class CustomPostgresContainer extends PostgreSQLContainer<CustomPostgresContainer> {

  private static final String IMAGE_VERSION = "postgres:alpine";
  private static CustomPostgresContainer container;

  private CustomPostgresContainer() {
    super(IMAGE_VERSION);
  }

  public static CustomPostgresContainer getInstance() {
    if (container == null) {
      container = new CustomPostgresContainer().withInitScript("import-to-docker-postgres.sql");
    }
    return container;
  }

  @Override
  public void start() {
    super.start();
    System.setProperty("DB_URL", container.getJdbcUrl());
    System.setProperty("DB_USERNAME", container.getUsername());
    System.setProperty("DB_PASSWORD", container.getPassword());
  }

  @Override
  public void stop() {
    //do nothing, JVM handles shut down
  }
}