package br.com.ifoodtest.integration.openweather;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
    name = "openWeather",
    url = "api.openweathermap.org/data/2.5",
    configuration = WeatherClientConfiguration.class)
public interface OpenWeatherClient {

  @RequestLine("GET /weather?q={city}&lang=pt_br&units=metric")
  WeatherDetailsResponse getWeatherDetails(@Param("city") String city);

  @RequestLine("GET /weather lat={lat}&lon={lon}&lang=pt_br&units=metric")
  WeatherDetailsResponse getWeatherDetails(@Param("lat") String lat, @Param("lon") String lon);
}
