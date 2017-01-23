
package com.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("cities")
    @Expose
    private List<String> cities = null;
    @SerializedName("spaces")
    @Expose
    private List<Space> spaces = null;

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public Data withCities(List<String> cities) {
        this.cities = cities;
        return this;
    }

    public List<Space> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<Space> spaces) {
        this.spaces = spaces;
    }

    public Data withSpaces(List<Space> spaces) {
        this.spaces = spaces;
        return this;
    }

}
