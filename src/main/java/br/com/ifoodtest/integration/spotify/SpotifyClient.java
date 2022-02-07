package br.com.ifoodtest.integration.spotify;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient( name = "spotify", url = "https://api.spotify.com/v1",configuration = SpotifyClientConfiguration.class)
public interface SpotifyClient {

  @RequestLine("GET /recommendations?seed_genres={genres}")
  SpotifySugestedPlaylisyResponse getTracksSugestionByGenre(@Param("genres") String genres);

}
