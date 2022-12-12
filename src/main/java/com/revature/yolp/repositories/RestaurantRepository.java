package com.revature.yolp.repositories;

import com.revature.yolp.entities.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, String> {
}
