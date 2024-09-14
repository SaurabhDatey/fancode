package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    private String city;
    private Geo geo;

    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}
    public void setGeo(Geo geo) {this.geo = geo;}
    public Geo getGeo() {
        return geo;
    }

    public  class Geo {
        private String lat;
        private String lng;

        public String getLat() {
            return lat;
        }
        public String getLng() {
            return lng;
        }

        public void setLat(String lat) {this.lat = lat;}
        public void setLng(String lng) {this.lng = lng;}
    }

}
