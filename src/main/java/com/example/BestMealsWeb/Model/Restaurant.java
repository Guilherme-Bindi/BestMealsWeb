package com.example.BestMealsWeb.Model;

public class Restaurant {

    private int id;

    private String name;

    private String address;

    private String city;

    private String state;

    private String zipCode;

//    private List<Meal> meals;

//    private List<RestaurantEval> evaluations;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

//    public List<RestaurantEval> getEvaluations() {
//        return evaluations;
//    }
//
//    public void setEvaluations(List<RestaurantEval> evaluations) {
//        this.evaluations = evaluations;
//    }
//
//    public List<Meal> getMeals() {
//        return meals;
//    }
//
//    public void setMeals(List<Meal> meals) {
//        this.meals = meals;
//    }
}
