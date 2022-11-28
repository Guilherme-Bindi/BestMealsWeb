package com.example.BestMealsWeb.DTO;

import com.example.BestMealsWeb.HTTP.HttpRestaurant;
import com.example.BestMealsWeb.Model.Restaurant;

import javax.validation.constraints.NotBlank;
import java.io.IOException;

public class RestaurantDTO {

    private int id;
    @NotBlank
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private double mediaAvaliacao;

    public RestaurantDTO() {
    }

    public RestaurantDTO(int id, String name, String address, String city, String state, String zipCode) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public RestaurantDTO(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.address = restaurant.getAddress();
        this.city = restaurant.getCity();
        this.state = restaurant.getState();
        this.zipCode = restaurant.getZipCode();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "RestaurantDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public double getMediaAvaliacao() {
        return mediaAvaliacao;
    }

    public void setMediaAvaliacao(double mediaAvaliacao) {
        this.mediaAvaliacao = mediaAvaliacao;
    }

    public void carregaAvaliacao() throws IOException, InterruptedException {
        setMediaAvaliacao( new HttpRestaurant().mediaAvaliacoes( this.id) );
    }
}
