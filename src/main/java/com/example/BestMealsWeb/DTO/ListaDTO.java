package com.example.BestMealsWeb.DTO;

import com.example.BestMealsWeb.HTTP.HttpRestaurant;

import java.io.IOException;
import java.util.List;

public class ListaDTO {

    List<RestaurantDTO> lista;

    public List<RestaurantDTO> getLista() {
        return lista;
    }

    public void setLista(List<RestaurantDTO> lista) {
        this.lista = lista;



    }

    public void carregaAvaliacoes(){
        this.lista.forEach(r -> {
            try {
                r.carregaAvaliacao();
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }
}
