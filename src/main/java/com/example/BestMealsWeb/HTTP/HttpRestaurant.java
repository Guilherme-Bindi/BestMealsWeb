package com.example.BestMealsWeb.HTTP;

import com.example.BestMealsWeb.DTO.RestaurantDTO;
import com.example.BestMealsWeb.DTO.ListaDTO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;

public class HttpRestaurant {

    @Autowired
    private Gson gson;

    private java.net.http.HttpRequest request;
    private final String get = "http://localhost:8080/Restaurant/:id";
    private final String getAll = "http://localhost:8080/Restaurant/all";
    private final String post = "http://localhost:8080/Restaurant";
    private final String put = "http://localhost:8080/Restaurant";
    private final String delete = "http://localhost:8080/Restaurant/:id";
    private final String mediaAvaliacoes = "http://localhost:8080/Restaurant/mediaEval/:id";

    public RestaurantDTO Get(Integer id) throws IOException, InterruptedException {

        request = HttpRequest.newBuilder()
                .uri(URI.create( this.get.replace(":id",id.toString()) ))
                .setHeader("Content-Type","application/json")
                .GET()
                .build();

        return new Gson().fromJson( new Request(request).requisitar().body() , RestaurantDTO.class);

    }

    public void Post(RestaurantDTO restaurantDTO) throws IOException, InterruptedException {
        System.out.println("INICIO POST HTTPRESTAURANT");

        request = HttpRequest.newBuilder()
                .uri(URI.create( this.post ))
                .setHeader("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString( new Gson().toJson(restaurantDTO) ) )
                .build();

        new Request(request).requisitar();
    }

    public void Put(RestaurantDTO restaurantDTO) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create( this.put ))
                .setHeader("Content-Type","application/json")
                .PUT(HttpRequest.BodyPublishers.ofString( new Gson().toJson(restaurantDTO) ) )
                .build();

        new Request(request).requisitar();
    }

    public void Delete(Integer id) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create( this.delete.replace(":id", id.toString() ) ))
                .setHeader("Content-Type","application/json")
                .DELETE()
                .build();

        new Request(request).requisitar();
    }

    public double mediaAvaliacoes(Integer id) throws IOException, InterruptedException {

        request = HttpRequest.newBuilder()
                .uri(URI.create( this.mediaAvaliacoes.replace(":id",id.toString()) ))
                .setHeader("Content-Type","application/json")
                .GET()
                .build();

        return Double.parseDouble( new Request(request).requisitar().body() );
    }

    public ListaDTO listarTodos() throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create( this.getAll ))
                .setHeader("Content-Type","application/json")
                .GET()
                .build();

        return new Gson().fromJson( new Request(request).requisitar().body() , ListaDTO.class );
    }

}
