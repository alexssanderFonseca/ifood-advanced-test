package br.com.ifoodtest.integration.spotify;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface SpotifyAccountClient {

  @RequestLine("POST /token")
  @Headers({"Content-Type:application/x-www-form-urlencoded", "Authorization: Basic {base64}"})
  TokenSpotifyResponse  getToken(@Param("grant_type") String grantType , @Param("base64") String base64);
}
