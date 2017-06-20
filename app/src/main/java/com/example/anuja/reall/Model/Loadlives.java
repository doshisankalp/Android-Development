package com.example.anuja.reall.Model;

/**
 * Created by ANUJA on 07/Jun/2017.
 */

public class Loadlives {
    private String name, age,gender,country;

    public Loadlives() {
    }
    public Loadlives(String name, String age, String gender, String country) {
        this.name = name;
        this.age =age;
        this.gender = gender;
        this.country=country;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getAge()
    {
        return age;
    }
    public void setAge(String year) {
        this.age = year;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String genre) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}

