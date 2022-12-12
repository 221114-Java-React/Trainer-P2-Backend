package com.revature.yolp.controllers;

import com.revature.yolp.dtos.responses.Principal;
import com.revature.yolp.entities.Review;
import com.revature.yolp.services.ReviewService;
import com.revature.yolp.services.TokenService;
import com.revature.yolp.utils.custom_exceptions.InvalidAuthException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final TokenService tokenService;

    public ReviewController(ReviewService reviewService, TokenService tokenService) {
        this.reviewService = reviewService;
        this.tokenService = tokenService;
    }

    @GetMapping("/id")
    public List<Review> getByRestaurantId(@RequestParam String id, HttpServletRequest req) {
        String token = req.getHeader("authorization");
        if (token == null || token.isEmpty()) throw new InvalidAuthException("Invalid token...");

        Principal principal = tokenService.extractRequesterDetails(token);
        if (principal == null) throw new InvalidAuthException("Please sign in to see reviews");

        return reviewService.getAllReviewsByRestaurantId(id);
    }


    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidAuthException.class)
    public InvalidAuthException handledAuthException (InvalidAuthException e) {
        return e;
    }
}
