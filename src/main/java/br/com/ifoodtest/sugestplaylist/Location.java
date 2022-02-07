package br.com.ifoodtest.sugestplaylist;

public class Location {

  private String city;
  private String lat;
  private String lon;

  public Location(String city, String lat, String lon) {
    this.city = city;
    this.lat = lat;
    this.lon = lon;
  }

  public boolean isValid() {
    return city != null || (lat != null && lon != null);
  }

  public String getCity() {
    return city;
  }

  public String getLat() {
    return lat;
  }

  public String getLon() {
    return lon;
  }
}
