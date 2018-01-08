package com.example.anuja.reall.Model;

/**
 * Created by ROHIT on 08-01-2018.
 */

public class FirstName {

    private String fname;
    private boolean isSelected;

    public FirstName() {

    }

    public FirstName(String name)
    {
        this.fname=name;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String name) {
        this.fname = name;
    }



}
