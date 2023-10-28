package com.oriz.backend_system.services;

import com.oriz.backend_system.exception.ProductException;
import com.oriz.backend_system.model.Product;
import com.oriz.backend_system.model.Review;
import com.oriz.backend_system.model.User;
import com.oriz.backend_system.repositories.ProductRepository;
import com.oriz.backend_system.repositories.ReviewRepository;
import com.oriz.backend_system.requests.ReviewRequest;
import com.oriz.backend_system.services.iservice.IReviewService;
import com.oriz.backend_system.services.iservice.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService implements IReviewService {

    private final ReviewRepository reviewRepository;
    private final IProductService productService;
    private final ProductRepository productRepository;

    @Override
    public Review createReview(ReviewRequest request, User user) throws ProductException {
        Product product = productService.findProductById(request.getProductId());

        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReview(review.getReview());
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReview(Long productId) {
        return reviewRepository.getAllProductsReview(productId);
    }
}
