package br.com.ifoodtest.integration.spotify;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenSpotifyResponse {

  @JsonProperty("access_token")
  private String accessToken;

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }
}
