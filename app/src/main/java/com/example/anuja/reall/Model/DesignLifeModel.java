package com.example.anuja.reall.Model;

/**
 * Created by ROHIT on 08-01-2018.
 */

public class DesignLifeModel {
    public String country;
    private boolean isSelected;


    public DesignLifeModel() {

    }

    public DesignLifeModel(String country)
    {
        this.country=country;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

