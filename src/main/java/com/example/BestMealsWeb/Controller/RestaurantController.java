package com.example.BestMealsWeb.Controller;

import com.example.BestMealsWeb.DTO.ListaDTO;
import com.example.BestMealsWeb.DTO.RestaurantDTO;
import com.example.BestMealsWeb.HTTP.HttpRestaurant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Parser;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    //Buscar
    @GetMapping
    public String get(Model model){
        model.addAttribute("restaurant", new RestaurantDTO(0, null, null,null,null,null) );
        return "restaurant";
    }

    //Buscar por Id (FUNCIONANDO APENAS QUANDO INSERE NO NAVEGADOR)
    @GetMapping("/{id}")
    public String get2(@PathVariable("id") Integer id ,Model model){
        RestaurantDTO restaurant = buscarItem(id);

        model.addAttribute("restaurant", restaurant);
        return "restaurant";
    }

    @GetMapping("buscar")
    public String getBuscar(Model model){
        model.addAttribute("id", 0);
        return "restaurant/buscar";
    }

    //Buscar restaurant por ID (botão)
    @PostMapping("buscar")
    public String postBuscar(Integer id, Model model){

        model.addAttribute( "restaurant", buscarItem(id) );

        return "restaurant";
    }

    //Buscar
    @GetMapping("form")
    public String getNew(RestaurantDTO restaurantDTO){
        return "restaurant/form";
    }

    //Restaurante - Alterar
    @PostMapping("form")
    public String postNew(RestaurantDTO restaurantDTO){
        return "restaurant/form";
    }

    //Cadastrar Restaurant
    @PostMapping
    public String post(@Valid RestaurantDTO restaurantDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "restaurant/form";
        } else {
            try {
                new HttpRestaurant().Post(restaurantDTO);
            } catch (Exception e) {
                System.out.println(e);
            }
            return "redirect:/";
        }
    }

    //Buscar
    @GetMapping("alterar")
    public String getUpdate(RestaurantDTO restaurantDTO){
        return "restaurant/alterar";
    }

    //Restaurante - Alterar
    @PostMapping("alterar")
    public String postUpdate(RestaurantDTO restaurantDTO){
        return "restaurant/alterar";
    }

    @PostMapping("update")
    public String put(@Valid RestaurantDTO restaurantDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/restaurant/alterar";
        } else {
            try {
                new HttpRestaurant().Put(restaurantDTO);
            } catch (Exception e) {
                System.out.println(e);
            }
            return "redirect:/";
        }
    }

    @GetMapping("apagar")
    public String apagar(Model model){
        return "restaurant/apagar";
    }

    @PostMapping("delete")
    public String delete(Integer id, Model model) {
        try {
            new HttpRestaurant().Delete( id );
        } catch (Exception e) {
            System.out.println(e);
        }

        return "redirect:/";
    }

    @GetMapping("listar")
    public String getAll(Model model){
        ListaDTO restaurantDTOS;
        try {
            restaurantDTOS = new HttpRestaurant().listarTodos();
            restaurantDTOS.carregaAvaliacoes();
        } catch (Exception e) {
            restaurantDTOS = new ListaDTO();
        }
        model.addAttribute("lista", restaurantDTOS.getLista() );
        return "restaurant/listar";
    }

    //Buscar restaurant na base (BestMealAPI)
    private RestaurantDTO buscarItem(Integer id){
        RestaurantDTO restaurant;
        try {
            restaurant = new HttpRestaurant().Get(id);
        } catch (Exception e){
            restaurant = null;
        }
        try {
            restaurant.getId();
            restaurant.setMediaAvaliacao( buscarAvaliacao(id) );
            System.out.println(restaurant.getMediaAvaliacao());
        } catch (Exception e){
            restaurant = new RestaurantDTO(0, null, null,null,null,null);
        }

        return restaurant;
    }

    //Busca a media das avaliacoes do restaurante
    public double buscarAvaliacao(Integer id){
        try {
            return new HttpRestaurant().mediaAvaliacoes(id);
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

}