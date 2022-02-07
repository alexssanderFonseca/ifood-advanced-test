package br.com.ifoodtest.integration.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class WeatherDetailsResponse {

  private String temperature;

  @Deprecated
  public WeatherDetailsResponse() {}

  public WeatherDetailsResponse(String temperature) {
    this.temperature = temperature;
  }

  @JsonProperty("main")
  public void setTemperature(Map<String, String> mainDetails) {
    this.temperature = mainDetails.get("temp");
  }

  public String getTemperature() {
    return temperature;
  }
}
