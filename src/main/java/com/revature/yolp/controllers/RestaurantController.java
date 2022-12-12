package com.revature.yolp.controllers;

import com.revature.yolp.entities.Restaurant;
import com.revature.yolp.services.RestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restoService;

    public RestaurantController(RestaurantService restoService) {
        this.restoService = restoService;
    }

    @GetMapping
    public List<Restaurant> getAll() {
        return restoService.getAllRestaurants();
    }
}
