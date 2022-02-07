package br.com.ifoodtest.sugestplaylist;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum PlaylistTypes {
  PARTY {
    @Override
    boolean isSuitable(Double temp) {
      return temp > 30;
    }
  },
  POP {
    @Override
    boolean isSuitable(Double temp) {
      return temp >= 15;
    }
  },
  ROCK {
    @Override
    boolean isSuitable(Double temp) {
      return temp > 10;
    }
  },
  CLASSICAL {
    @Override
    boolean isSuitable(Double temp) {
      return temp < 10;
    }
  };

  abstract boolean isSuitable(Double temp);

  public static PlaylistTypes findByTemperature(Double temperature) {

    return Arrays.stream(values())
        .filter(playlistType -> playlistType.isSuitable(temperature))
        .collect(Collectors.toList())
        .get(0);
  }
}
