package com.application.services;

import com.application.domain.City;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.tcp.TcpClient;

@Service
public class CitiesService {

  @Value("${backingServices.citiesUrl}")
  private String citiesUrl;


  public City readCity(long cityId, Long delay) {

    TcpClient tcpClient = TcpClient
        .create()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
        .doOnConnected(connection -> {
          connection.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS));
          connection.addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS));
        });

    WebClient client = WebClient.builder()
        .baseUrl(citiesUrl)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        //  .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
        .build();

    Mono<City> city = client.method(HttpMethod.GET)
        .uri("/city/{cityId}", cityId)
        .retrieve()
        .bodyToMono(City.class);

    return city.block();

  }

}
