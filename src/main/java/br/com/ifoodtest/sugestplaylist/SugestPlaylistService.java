package br.com.ifoodtest.sugestplaylist;

import br.com.ifoodtest.integration.openweather.OpenWeatherClient;
import br.com.ifoodtest.integration.openweather.WeatherDetailsResponse;
import br.com.ifoodtest.integration.spotify.SpotifyClient;
import br.com.ifoodtest.integration.spotify.SpotifySugestedPlaylisyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SugestPlaylistService {

  private SpotifyClient spotifyClient;

  private OpenWeatherClient openWeatherClient;

  @Autowired
  public SugestPlaylistService(SpotifyClient spotifyClient, OpenWeatherClient openWeatherClient) {
    this.spotifyClient = spotifyClient;
    this.openWeatherClient = openWeatherClient;
  }

  public SpotifySugestedPlaylisyResponse execute(Location location) {

    Double temp = getTemperature(location);
    String genre = checkWhichPlaylistIsSuitable(temp);
    return getSugestionSoundtracks(genre);
  }

  private SpotifySugestedPlaylisyResponse getSugestionSoundtracks(String genre) {
    return spotifyClient.getTracksSugestionByGenre(genre);
  }

  private Double getTemperature(Location location) {
    WeatherDetailsResponse weatherDetailsResponse =
        location.getCity() != null
            ? openWeatherClient.getWeatherDetails(location.getCity())
            : openWeatherClient.getWeatherDetails(location.getLat(), location.getLon());
    return Double.valueOf(weatherDetailsResponse.getTemperature());
  }

  private String checkWhichPlaylistIsSuitable(Double temperature) {

    PlaylistTypes type = PlaylistTypes.findByTemperature(temperature);
    return type.name().toLowerCase();
  }
}
