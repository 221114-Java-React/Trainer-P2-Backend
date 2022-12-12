package com.revature.yolp.services;

import com.revature.yolp.entities.Restaurant;
import com.revature.yolp.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restoRepo;

    public RestaurantService(RestaurantRepository restoRepo) {
        this.restoRepo = restoRepo;
    }

    public List<Restaurant> getAllRestaurants() {
        return (List<Restaurant>) restoRepo.findAll();
    }
}
