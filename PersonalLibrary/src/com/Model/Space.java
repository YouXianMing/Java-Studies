
package com.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Space {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("facilities")
    @Expose
    private List<Object> facilities = null;
    @SerializedName("activityCount")
    @Expose
    private Integer activityCount;
    @SerializedName("enCity")
    @Expose
    private String enCity;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("background")
    @Expose
    private String background;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("timeZone")
    @Expose
    private String timeZone;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("englishName")
    @Expose
    private String englishName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Space withId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Space withLon(Double lon) {
        this.lon = lon;
        return this;
    }

    public List<Object> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Object> facilities) {
        this.facilities = facilities;
    }

    public Space withFacilities(List<Object> facilities) {
        this.facilities = facilities;
        return this;
    }

    public Integer getActivityCount() {
        return activityCount;
    }

    public void setActivityCount(Integer activityCount) {
        this.activityCount = activityCount;
    }

    public Space withActivityCount(Integer activityCount) {
        this.activityCount = activityCount;
        return this;
    }

    public String getEnCity() {
        return enCity;
    }

    public void setEnCity(String enCity) {
        this.enCity = enCity;
    }

    public Space withEnCity(String enCity) {
        this.enCity = enCity;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Space withType(Integer type) {
        this.type = type;
        return this;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Space withBackground(String background) {
        this.background = background;
        return this;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Space withLat(Double lat) {
        this.lat = lat;
        return this;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Space withTimeZone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Space withCity(String city) {
        this.city = city;
        return this;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Space withCreated(String created) {
        this.created = created;
        return this;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Space withDistance(Integer distance) {
        this.distance = distance;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Space withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Space withName(String name) {
        this.name = name;
        return this;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public Space withEnglishName(String englishName) {
        this.englishName = englishName;
        return this;
    }

}
