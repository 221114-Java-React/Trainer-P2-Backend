package com.revature.yolp.services;

import com.revature.yolp.dtos.requests.ReviewRequest;
import com.revature.yolp.entities.Review;
import com.revature.yolp.repositories.ReviewRepository;
import com.revature.yolp.utils.custom_exceptions.InvalidReviewException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepo;

    public ReviewService(ReviewRepository reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    public List<Review> getAllReviewsByRestaurantId(String id) {
        return reviewRepo.findAllByRestaurantId(id);
    }

    public void saveReviewByRestaurantId(ReviewRequest req) {
        reviewRepo.save(UUID.randomUUID().toString(), req.getRating(), req.getMsg(), req.getUsername(), req.getRestaurant_id(), req.getUser_id());
    }

    public void deleteReviewByRestaurantIdAndUserId(String restaurant_id, String id) {
        reviewRepo.delete(restaurant_id, id);
    }

    public boolean isValidRating(int rating) {
        if (rating < 0 || rating > 5) throw new InvalidReviewException("Rating must be between 0-5");
        return true;
    }

    public boolean isOneReview(String id, String username) {
        List<Review> reviews = reviewRepo.findAllByRestaurantId(id);
        for (Review r : reviews) {
            if (r.getUsername().equals(username)) throw new InvalidReviewException("You can only leave one review per restaurant...");
        }
        return true;
    }
}
