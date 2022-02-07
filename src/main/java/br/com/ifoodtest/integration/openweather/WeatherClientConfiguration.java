package br.com.ifoodtest.integration.openweather;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherClientConfiguration {

  @Value("${weather.apiKey}")
  private String apiKey;

  @Bean(name = "weatherRequestInterceptor")
  public RequestInterceptor requestInterceptor() {
    return requestTemplate -> {
      requestTemplate.query("apikey", apiKey);
    };
  }
}
