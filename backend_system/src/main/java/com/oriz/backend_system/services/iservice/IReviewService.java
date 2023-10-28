package com.oriz.backend_system.services.iservice;

import com.oriz.backend_system.exception.ProductException;
import com.oriz.backend_system.model.Review;
import com.oriz.backend_system.model.User;
import com.oriz.backend_system.requests.ReviewRequest;

import java.util.List;

public interface IReviewService {
    public Review createReview(ReviewRequest request, User user) throws ProductException;
    public List<Review> getAllReview(Long productId);
}
