package com.revature.yolp.services;

import com.revature.yolp.entities.Review;
import com.revature.yolp.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepo;

    public ReviewService(ReviewRepository reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    public List<Review> getAllReviewsByRestaurantId(String id) {
        return reviewRepo.findAllByRestaurantId(id);
    }
}
