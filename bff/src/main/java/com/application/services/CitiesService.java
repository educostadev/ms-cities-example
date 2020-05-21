package com.application.services;

import com.application.domain.City;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CitiesService {

  private final WebClient webClientCities;

  public City readCity(long cityId, long delay) {

    Mono<City> city = webClientCities.method(HttpMethod.GET)
        .uri("/city/{cityId}", cityId)
        .header("delay", String.valueOf(delay))
        .retrieve()
        .bodyToMono(City.class);

    return city.block();

  }

}
