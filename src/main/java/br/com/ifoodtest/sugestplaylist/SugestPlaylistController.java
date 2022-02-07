package br.com.ifoodtest.sugestplaylist;

import br.com.ifoodtest.integration.spotify.SpotifySugestedPlaylisyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playlist")
public class SugestPlaylistController {

  SugestPlaylistService sugestPlaylistService;

  @Autowired
  public SugestPlaylistController(SugestPlaylistService sugestPlaylistService) {
    this.sugestPlaylistService = sugestPlaylistService;
  }

  @GetMapping
  public ResponseEntity<?> execute(
      @RequestParam(name = "city", required = false) String city,
      @RequestParam(name = "lat", required = false) String lat,
      @RequestParam(name = "lon", required = false) String lon) {

    Location location = new Location(city, lat, lon);

    if (!location.isValid()) {
      return ResponseEntity.badRequest().build();
    }

    SpotifySugestedPlaylisyResponse response = sugestPlaylistService.execute(location);

    return ResponseEntity.ok(response);
  }
}
