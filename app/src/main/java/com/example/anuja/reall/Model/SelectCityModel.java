package com.example.anuja.reall.Model;

/**
 * Created by ROHIT on 08-01-2018.
 */

public class SelectCityModel {
    public String city;
    private boolean isSelected;


    public SelectCityModel() {

    }

    public SelectCityModel(String city)
    {
        this.city=city;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

