package com.oriz.backend_system.services.iservice;

import com.oriz.backend_system.exception.ProductException;
import com.oriz.backend_system.model.Rating;
import com.oriz.backend_system.model.User;
import com.oriz.backend_system.requests.RatingRequest;

import java.util.List;

public interface IRatingService {
    public Rating createRating(RatingRequest request, User user) throws ProductException;
    public List<Rating> getProductsRating(Long productId);

}
