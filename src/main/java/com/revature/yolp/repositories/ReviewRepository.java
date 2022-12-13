package com.revature.yolp.repositories;

import com.revature.yolp.entities.Review;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, String> {
    @Query(value = "SELECT * FROM reviews WHERE restaurant_id = ?1", nativeQuery = true)
    List<Review> findAllByRestaurantId(String id);

    @Modifying
    @Query(value = "INSERT INTO reviews(id, rating, msg, username, restaurant_id, user_id) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void save(String id, int rating, String msg, String username, String restaurant_id, String user_id);

    @Modifying
    @Query(value = "DELETE FROM reviews WHERE restaurant_id = ?1 AND user_id = ?2", nativeQuery = true)
    void delete(String restaurant_id, String id);
}
