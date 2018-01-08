package com.example.anuja.reall.Model;

/**
 * Created by ANUJA on 07/Jun/2017.
 */

public class Completedlives {
    private String name,gender,country;
    private int age,reallivesGameId;
    private boolean isSelected;
    public Completedlives() {
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Completedlives(Completedlives c) {

        this.name = c.name;
        this.age =c.age;
        this.gender = c.gender;
        this.country= c.country;
    }
    public Completedlives(String name, int age, String gender, String country,int id) {
        this.name = name;
        this.age =age;
        this.gender = gender;
        this.country=country;
        this.reallivesGameId=id;
    }
    public Completedlives(String name) {
        this.name = name;
        this.age=90;
        this.gender="female";
        this.country="india";


    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }
    public void setAge(int year) {
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

    public int getReallivesGameId(){
        return reallivesGameId;

    }

    public  void setReallivesGameId(int id){
        this.reallivesGameId=id;
    }
}

