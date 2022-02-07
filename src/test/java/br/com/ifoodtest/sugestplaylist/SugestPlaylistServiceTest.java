package br.com.ifoodtest.sugestplaylist;

import br.com.ifoodtest.integration.openweather.OpenWeatherClient;
import br.com.ifoodtest.integration.openweather.WeatherDetailsResponse;
import br.com.ifoodtest.integration.spotify.SpotifyClient;
import br.com.ifoodtest.integration.spotify.SpotifySugestedPlaylisyResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

class SugestPlaylistServiceTest {

  private SpotifyClient spotifyClient = Mockito.mock(SpotifyClient.class);
  private OpenWeatherClient openWeatherClient = Mockito.mock(OpenWeatherClient.class);

  @BeforeEach
  public void setup() {
    Mockito.when(openWeatherClient.getWeatherDetails("New York"))
        .thenReturn(new WeatherDetailsResponse("31.0"));
    Mockito.when(openWeatherClient.getWeatherDetails("1234", "4321"))
        .thenReturn(new WeatherDetailsResponse("31.0"));
    Mockito.when(spotifyClient.getTracksSugestionByGenre("party"))
        .thenReturn(
            new SpotifySugestedPlaylisyResponse(Arrays.asList("Music 1", "Music 2", "Music 3")));
  }

  @Test
  @DisplayName("Should found tracks")
  void shouldReturnListOfTracks() {
    SugestPlaylistService sugestPlaylistService =
        new SugestPlaylistService(spotifyClient, openWeatherClient);
    SpotifySugestedPlaylisyResponse response =
        sugestPlaylistService.execute(new Location("New York", null, null));

    Assertions.assertEquals(3, response.getTracks().size());
  }
}
