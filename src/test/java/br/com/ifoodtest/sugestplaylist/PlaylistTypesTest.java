package br.com.ifoodtest.sugestplaylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlaylistTypesTest {

  @Test
  @DisplayName("Should return party type")
  void shouldReturnParty() {
    PlaylistTypes type = PlaylistTypes.findByTemperature(30.1);
    Assertions.assertEquals("PARTY", type.name());
  }

  @Test
  @DisplayName("Should return pop type")
  void shouldReturnPop() {
    PlaylistTypes type = PlaylistTypes.findByTemperature(15.1);
    Assertions.assertEquals("POP", type.name());
  }

  @Test
  @DisplayName("Should return pop type")
  void shouldReturnRock() {
    PlaylistTypes type = PlaylistTypes.findByTemperature(10.1);
    Assertions.assertEquals("ROCK", type.name());
  }

  @Test
  @DisplayName("Should return classical type")
  void shouldReturnClassical() {
    PlaylistTypes type = PlaylistTypes.findByTemperature(9.9);
    Assertions.assertEquals("CLASSICAL", type.name());
  }
}
