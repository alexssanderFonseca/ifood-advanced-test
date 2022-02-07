package br.com.ifoodtest.sugestplaylist;

import br.com.ifoodtest.integration.spotify.SpotifySugestedPlaylisyResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

public class SugestPlaylistControllerTest {

  @Test
  @DisplayName("Should not returns playlist without city and lat/lon ")
  void shouldNotReturnsAPlaylistWithoutCityLatLon() {
    SugestPlaylistService sugestPlaylistService = Mockito.mock(SugestPlaylistService.class);
    SugestPlaylistController controller = new SugestPlaylistController(sugestPlaylistService);

    HttpStatus statusCode = controller.execute(null, null, null).getStatusCode();
    Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), statusCode.value());
  }

  @Test
  @DisplayName("Should not returns playlist without city and lat")
  void shouldNotReturnsAPlaylistWithoutCityLat() {
    SugestPlaylistService sugestPlaylistService = Mockito.mock(SugestPlaylistService.class);
    SugestPlaylistController controller = new SugestPlaylistController(sugestPlaylistService);

    HttpStatus statusCode = controller.execute(null, "4286428", null).getStatusCode();
    Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), statusCode.value());
  }

  @Test
  @DisplayName("Should returns playlist")
  void shouldReturnsAPlaylist() {
    SugestPlaylistService sugestPlaylistService = Mockito.mock(SugestPlaylistService.class);
    Location location = new Location(null, "222", "333");
    Mockito.when(sugestPlaylistService.execute(location))
        .thenReturn(
            new SpotifySugestedPlaylisyResponse(Arrays.asList("Music 1", "Music 2", "Music 3")));
    SugestPlaylistController controller = new SugestPlaylistController(sugestPlaylistService);
    ResponseEntity<?> response = controller.execute(null, "222", "333");

    Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
  }
}
