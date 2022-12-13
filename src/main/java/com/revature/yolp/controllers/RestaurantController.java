package com.revature.yolp.controllers;

import com.revature.yolp.entities.Restaurant;
import com.revature.yolp.services.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
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

    @GetMapping("/id")
    public Optional<Restaurant> getById(@RequestParam String id) {
        return restoService.getRestaurantById(id);
    }
}
