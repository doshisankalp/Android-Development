package com.example.anuja.reall.Model;

/**
 * Created by ANUJA on 07/Jun/2017.
 */

public class Loadlives {
    private String name,gender,country;
    private int age,reallivesGameId;
    private boolean isSelected;
    public Loadlives() {
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Loadlives(Loadlives l) {

        this.name = l.name;
        this.age =l.age;
        this.gender = l.gender;
        this.country=l.country;
    }
    public Loadlives(String name, int age, String gender, String country,int id) {
        this.name = name;
        this.age =age;
        this.gender = gender;
        this.country=country;
        this.reallivesGameId=id;
    }
    public Loadlives(String name) {
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

