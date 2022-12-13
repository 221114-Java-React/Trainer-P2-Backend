package com.revature.yolp.dtos.requests;

public class DeleteReviewRequest {
    private String restaurant_id;
    private String user_id;

    public DeleteReviewRequest() {
        super();
    }

    public DeleteReviewRequest(String restaurant_id, String user_id) {
        this.restaurant_id = restaurant_id;
        this.user_id = user_id;
    }

    public String getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(String restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "DeleteReviewRequest{" +
                "restaurant_id='" + restaurant_id + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
