package br.com.ifoodtest.integration.spotify;

import feign.Feign;
import feign.RequestInterceptor;
import feign.form.FormEncoder;
import feign.jackson.JacksonDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Base64Utils;

@Configuration
public class SpotifyClientConfiguration {

  @Value("${spotify.url}")
  private String url;

  @Value("${spotify.clientId}")
  private String clientId;

  @Value("${spotify.clientSecret}")
  private String clientSecret;

  private static String token;

  @Bean(name = "spotifyRequestInterceptor")
  public RequestInterceptor requestInterceptor() {

    return requestTemplate -> {
      token = getToken();
      requestTemplate.header("Authorization", String.format("Bearer %s", token));
    };
  }

  private String getToken() {

    if (token != null) {
      return token;
    }

    String base64 = Base64Utils.encodeToString((clientId + ":" + clientSecret).getBytes());
    SpotifyAccountClient spotifyAccountClient =
        Feign.builder()
            .encoder(new FormEncoder())
            .decoder(new JacksonDecoder())
            .target(SpotifyAccountClient.class, url);

    return spotifyAccountClient.getToken("client_credentials", base64).getAccessToken();
  }
}
