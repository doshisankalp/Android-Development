package com.example.anuja.reall.Model;

/**
 * Created by ROHIT on 08-01-2018.
 */

public class SurnameModel {

    private String surname;
    private boolean isSelected;

    public SurnameModel() {

    }

    public SurnameModel(String surname)
    {
        this.surname=surname;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String getSname() {
        return surname;
    }

    public void setSname(String surname) {
        this.surname = surname;
    }



}
