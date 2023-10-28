package com.oriz.backend_system.services;

import com.oriz.backend_system.exception.ProductException;
import com.oriz.backend_system.model.Product;
import com.oriz.backend_system.model.Rating;
import com.oriz.backend_system.model.User;
import com.oriz.backend_system.repositories.RatingRepository;
import com.oriz.backend_system.requests.RatingRequest;
import com.oriz.backend_system.services.iservice.IRatingService;
import com.oriz.backend_system.services.iservice.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService implements IRatingService {

    private final RatingRepository ratingRepository;
    private final IProductService productService;


    @Override
    public Rating createRating(RatingRequest request, User user) throws ProductException {
        Product product = productService.findProductById(request.getProductId());
        Rating rating = new Rating();
        rating.setProduct(product);
        rating.setRating(request.getRating());
        rating.setUser(user);
        rating.setCreatedAt(LocalDateTime.now());

        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getProductsRating(Long productId) {
        return ratingRepository.getAllProductsRating(productId);
    }
}
