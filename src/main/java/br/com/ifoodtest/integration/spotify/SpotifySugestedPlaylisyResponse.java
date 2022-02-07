package br.com.ifoodtest.integration.spotify;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SpotifySugestedPlaylisyResponse {
  List<String> tracks;

  @Deprecated
  public SpotifySugestedPlaylisyResponse() {}

  public SpotifySugestedPlaylisyResponse(List<String> tracks) {
    this.tracks = tracks;
  }

  @JsonProperty("tracks")
  public void setTracks(List<HashMap<String, Object>> tracksJson) {
    tracks =
        tracksJson.stream()
            .map(trackJson -> trackJson.get("name").toString())
            .collect(Collectors.toList());
  }

  public List<String> getTracks() {
    return tracks;
  }
}
