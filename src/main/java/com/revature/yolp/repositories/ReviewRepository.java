package com.revature.yolp.repositories;

import com.revature.yolp.entities.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, String> {
    @Query(value = "SELECT * FROM reviews WHERE restaurant_id = ?1", nativeQuery = true)
    List<Review> findAllByRestaurantId(String id);
}
